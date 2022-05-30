package ksr.zad2.soft;

import javafx.application.Application;
import ksr.zad2.soft.data.SpeedDatingRecord;
import ksr.zad2.soft.database.SpeedDatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.CDATASection;

import java.util.List;

@SpringBootApplication
public class SoftApplication  {

    @Autowired
    private SpeedDatingRepository speedDatingRepository;
    public static List<SpeedDatingRecord> database;
    public void main(String[] args) {
        Application.launch(Main.class, args);
        database = this.speedDatingRepository.findAll();
    }

}
