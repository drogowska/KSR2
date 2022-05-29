package ksr.zad2.soft;

import ksr.zad2.soft.database.SpeedDatingRepository;
import ksr.zad2.soft.fuzzy.CompoundVariable;
import ksr.zad2.soft.fuzzy.Defined;
import ksr.zad2.soft.fuzzy.LinguisticSummary;
import ksr.zad2.soft.fuzzy.Summarizer;
import ksr.zad2.soft.quantifier.FuzzyQuantifier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@EnableAutoConfiguration
class SoftApplicationTests {

    @Autowired
    private SpeedDatingRepository repository;

    @Test
    void contextLoads() {
        FuzzyQuantifier q = Defined.quantifier.get(3);
        CompoundVariable s = new CompoundVariable("age equals young", List.of(Defined.age.getByName("young")),
                Defined.age.getByName("young").getFuzzy().getUniverseOfDiscourse());
        LinguisticSummary linguisticSummary = new LinguisticSummary(q, s, repository.findAll(), "people");
        System.out.println(linguisticSummary.toString() + "[" + linguisticSummary.t1() + "]");
    }

}
