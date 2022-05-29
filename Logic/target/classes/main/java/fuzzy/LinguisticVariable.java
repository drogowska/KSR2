package fuzzy;

import data.SpeedDatingRecord;
import functions.UniverseOfDiscourse;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Getter
public class LinguisticVariable {

    String name;             //L
    List<Label> labels;  //with used G and K
    private UniverseOfDiscourse universeOfDiscourse;
    HashMap<SpeedDatingRecord, Double> map = new HashMap<>();

    public LinguisticVariable(String name, List<Label> labels, UniverseOfDiscourse universeOfDiscourse) {
        this.name = name;
        this.labels = labels;
        this.universeOfDiscourse = universeOfDiscourse;
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
}
