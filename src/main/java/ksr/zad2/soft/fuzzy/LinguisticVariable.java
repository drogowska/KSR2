package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.SpeedDatingRecord;
import ksr.zad2.soft.functions.UniverseOfDiscourse;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static ksr.zad2.soft.SoftApplication.database;

@Getter
public class LinguisticVariable {

    String name;             //L
    List<Label> labels;  //with used G and K
    private UniverseOfDiscourse universeOfDiscourse;

    public LinguisticVariable(String name, List<Label> labels, UniverseOfDiscourse universeOfDiscourse) {
        this.name = name;
        this.labels = labels;
        this.universeOfDiscourse = universeOfDiscourse;
//        database.forEach(d -> map.put(d, labels.get(0).getFuzzy().getFunction().calculate(d)));
    }

    public Label getByName(String name) {
        int id = 0;
        for (Label l : labels)
            if (Objects.equals(l.getLabel(), name))
                id = labels.indexOf(l);
        return labels.get(id);
    }

    public LinguisticVariable(List<Label> labels) {
        this.labels = labels;
    }

    public String getName() {
        return name;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public Double exstract(int i) {
        Double d;
        return 0.0;
    }
}
