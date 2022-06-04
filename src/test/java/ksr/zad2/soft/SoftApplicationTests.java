package ksr.zad2.soft;

import ksr.zad2.soft.database.SpeedDatingRepository;
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
        String summarizerLabel = "age is old";
        FuzzySet<Double> age = new FuzzySet<>();
        repository.getDistinctAge().forEach(a -> age.add(a));
    }

}
