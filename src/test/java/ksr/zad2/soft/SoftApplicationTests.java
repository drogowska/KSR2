package ksr.zad2.soft;

import ksr.zad2.soft.database.PostgreSQLJPA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration
class SoftApplicationTests {

    @Autowired
    private PostgreSQLJPA jpa;

    @Test
    void contextLoads() {
        System.out.println(jpa.getAllRecords().size());
    }

}
