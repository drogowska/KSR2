package ksr.zad2.soft;

import ksr.zad2.soft.data.SpeedDatingRecord;
import ksr.zad2.soft.database.SpeedDatingRepository;
import ksr.zad2.soft.functions.UniverseOfDiscourse;
import ksr.zad2.soft.fuzzy.CompoundVariable;
import ksr.zad2.soft.fuzzy.Defined;
import ksr.zad2.soft.fuzzy.FuzzyQuantifier;
import ksr.zad2.soft.fuzzy.LinguisticSummary;
import ksr.zad2.soft.set.FuzzySet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static ksr.zad2.soft.SoftApplication.database;

@SpringBootTest
@EnableAutoConfiguration
class SoftApplicationTests {

    @Autowired
    private SpeedDatingRepository repository;

    @Test
    void contextLoads() {
        FuzzyQuantifier q = Defined.quantifier.get(3);
//        CompoundVariable s = new CompoundVariable("age equals young", List.of(Defined.age.getByName("young")),
//                Defined.age.getByName("young").getFuzzy().getUniverseOfDiscourse());
        List<SpeedDatingRecord> datingRecords = repository.findAll();
//        LinguisticSummary linguisticSummary = new LinguisticSummary(q, s, datingRecords, "people");
//        System.out.println(linguisticSummary.toString() + "[" + linguisticSummary.T1() + "]");

        SpeedDatingRecord r = datingRecords.get(0);
        FuzzySet set =Defined.age.getLabels().get(0).getFuzzy();
        set.getValue((double) r.getAge());

    }

}
