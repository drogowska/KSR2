package ksr.zad2.soft;

import javafx.application.Application;
import ksr.zad2.soft.data.CustomRecord;
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
    public static List<CustomRecord> cutDB;
    public void main(String[] args) {
        Application.launch(Main.class, args);
        database = this.speedDatingRepository.findAll();
        database.forEach(d -> cutDB.add(new CustomRecord(d.getId(), d.getAge(), d.getGender(), d.getRace(),
                d.getField(), d.getD_age(), d.getImportance_same_race(), d.getImportance_same_religion(), d.getPref_o_ambitious(),
                d.getPref_o_intelligence(), d.getSincere(), d.getTvsports(), d.getExpected_num_interested_in_me(), d.getGuess_prob_liked())));
    }

}
