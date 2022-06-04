package ksr.zad2.soft;

import ksr.zad2.soft.data.SpeedDatingRecord;
import ksr.zad2.soft.database.SpeedDatingRepository;
import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.set.FuzzySet;
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
    void Test() {
        List<SpeedDatingRecord> rows = repository.findAll();
        MembershipFunction<T>

        FuzzySet<Double> summarizer = new FuzzySet<>();
        FuzzySet<Double> quantifier = new FuzzySet<>();
        String subject = "People";

    }

}
