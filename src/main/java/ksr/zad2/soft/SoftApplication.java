package ksr.zad2.soft;

import javafx.application.Application;
import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.data.SpeedDatingRecord;
import ksr.zad2.soft.database.SpeedDatingRepository;
import ksr.zad2.soft.functions.Extractor;
import ksr.zad2.soft.fuzzy.*;
import ksr.zad2.soft.set.ClassicSet;
import ksr.zad2.soft.set.FuzzySet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.w3c.dom.CDATASection;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SoftApplication  {

    @Autowired
    private SpeedDatingRepository speedDatingRepository;
    public static List<SpeedDatingRecord> database;
    public static ClassicSet<CustomRecord> cutDB = new ClassicSet();
    public static void main(String[] args) {
        Application.launch(Main.class, args);
        System.out.println(database.size());
    }
    @Autowired
    private void load() {
        database = speedDatingRepository.findAll();
        database.forEach(d -> cutDB.add(new CustomRecord(d.getId(), d.getAge(), d.getGender(), d.getRace(),
                d.getField(), d.getD_age(), d.getImportance_same_race(), d.getImportance_same_religion(), d.getPref_o_ambitious(),
                d.getPref_o_intelligence(), d.getSincere(), d.getTvsports(), d.getExpected_num_interested_in_me(), d.getGuess_prob_liked())));
        FuzzyQuantifier q = Defined.quantifier.get(3);
        FuzzySet s = Defined.age.getByName("young");
        double y = Extractor.age(cutDB.get(0));
        System.out.println(y);
        System.out.println(s.getFunction().calculate(cutDB.get(0)));
//        System.out.println(s.getFunction().;
        q.getLabels().get(0).getFunction().calculate((double) cutDB.get(0).getAge());
        q.getLabels().get(0).getFunction().calculate(Extractor.age(cutDB.get(0)));
        CompoundVariable ss = new CompoundVariable(
                List.of(Defined.age.getByName("young"),Defined.d_age.getByName("tiny")),
                List.of("and"));
        SpeedDatingRecord r = database.get(0);
//        LinguisticSummary linguisticSummary = new LinguisticSummary(q, s, cutDB, "people");


    }

}
