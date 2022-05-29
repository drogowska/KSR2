package ksr.zad2.soft;

import javafx.application.Application;
import ksr.zad2.soft.database.SpeedDatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoftApplication  {

    @Autowired
    private SpeedDatingRepository speedDatingRepository;

    public static void main(String[] args) {
        Application.launch(Main.class, args);
    }

}
