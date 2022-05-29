package ksr.zad2.soft;

import ksr.zad2.soft.database.SpeedDatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoftApplication implements CommandLineRunner {

    @Autowired
    private SpeedDatingRepository speedDatingRepository;

    public static void main(String[] args) {
        SpringApplication.run(SoftApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println(speedDatingRepository.findAll().size());
    }

}
