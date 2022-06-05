package ksr.zad2.soft;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.database.SpeedDatingRepository;
import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.functions.TrapezoidalFunction;
import ksr.zad2.soft.fuzzy.*;
import ksr.zad2.soft.set.FuzzySet;
import org.junit.jupiter.api.BeforeAll;
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

    private static MembershipFunction quantifierFunction;
    private static Quantifier quantifier;
    private static MembershipFunction summarizerFunction;
    private static MembershipFunction qualifierFunction;
    private static Label label1;
    private static Label label2;
    private static Summarizer summarizer;
    private static List<CustomRecord> subject1;
    private static Qualifier qualifier;

    @BeforeAll
    static void setup() {
        quantifierFunction = new TrapezoidalFunction(100, 4600, 10000, 7000);
        quantifier = new Quantifier("Most of", quantifierFunction);

        qualifierFunction = new TrapezoidalFunction(1, 4, 5, 6);
        label2 = new Label("a bit boring", new FuzzySet(qualifierFunction));
        qualifier = new Qualifier(label2, AttributeEnum.valueOf("funny"));

        summarizerFunction = new TrapezoidalFunction(28, 34, 40, 44);
        label1 = new Label("young", new FuzzySet(summarizerFunction));
        summarizer = new Summarizer(label1, AttributeEnum.valueOf("age"), ConnectiveEnum.AND);
    }

    @Test
    void testForm1() {
        subject1 = repository.findAll().stream().map(r -> {
            CustomRecord customRecord = r.getCustomRecord();
            customRecord.setName("People");
            return customRecord;
        }).collect(Collectors.toList());

        LinguisticSummary summary = new LinguisticSummary(quantifier, null, List.of(summarizer, summarizer), subject1);
        System.out.println(summary.toString() + " [" + summary.getT1() + "]");

        summary.getT().forEach(System.out::println);
    }

    @Test
    void testForm2() {
        subject1 = repository.findAll().stream().map(r -> {
            CustomRecord customRecord = r.getCustomRecord();
            customRecord.setName("People");
            return customRecord;
        }).collect(Collectors.toList());

        LinguisticSummary summary = new LinguisticSummary(quantifier, qualifier, List.of(summarizer, summarizer, summarizer), subject1);
        System.out.println(summary.toString() + " [" + summary.getT1() + "]");

        summary.getT().forEach(System.out::println);
    }

}
