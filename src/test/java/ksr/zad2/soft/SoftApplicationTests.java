package ksr.zad2.soft;

import ksr.zad2.soft.database.SpeedDatingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration
class SoftApplicationTests {

    @Autowired
    private SpeedDatingRepository repository;

    @Test
    void Test() {
    }

}
