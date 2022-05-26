package fuzzy;

import functions.UniverseOfDiscourse;
import set.FuzzySet;
import set.Label;

import java.util.List;


public class LinguisticVariable {

    private String name;             //L
    private List<Label> labels;  //with used G and K
    private UniverseOfDiscourse universeOfDiscourse;

    public LinguisticVariable(String name, List<Label> labels, UniverseOfDiscourse universeOfDiscourse) {
        this.name = name;
        this.labels = labels;
        this.universeOfDiscourse = universeOfDiscourse;
    }

}
