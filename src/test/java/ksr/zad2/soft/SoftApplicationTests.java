package ksr.zad2.soft;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.data.SpeedDatingRecord;
import ksr.zad2.soft.database.SpeedDatingRepository;
import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.functions.TrapezoidalFunction;
import ksr.zad2.soft.fuzzy.*;
import ksr.zad2.soft.set.FuzzySet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@EnableAutoConfiguration
class SoftApplicationTests {

    @Autowired
    private SpeedDatingRepository repository;

    @Test
    void Test() {
        MembershipFunction quantifierFunction = new TrapezoidalFunction(4100, 4600, 10000, 10000);
        Quantifier quantifier = new Quantifier("Most of", quantifierFunction);

        MembershipFunction summarizerFunction = new TrapezoidalFunction(28, 34, 40, 44);
        Label label = new Label("young", new FuzzySet(summarizerFunction)); // age
        Summarizer summarizer = new Summarizer(label, AttributeEnum.valueOf("age"));

        List<CustomRecord> subject = repository.findAll().stream().map(r -> {
            CustomRecord customRecord = r.getCustomRecord();
            customRecord.setName("People");
            return customRecord;
        }).collect(Collectors.toList());

        LinguisticSummary summary = new LinguisticSummary(quantifier, List.of(summarizer), subject);
        System.out.println(summary.toString() + " [" + summary.getT1() + "]");
    }

}
