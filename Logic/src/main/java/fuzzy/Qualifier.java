package fuzzy;

import functions.UniverseOfDiscourse;
import set.FuzzySet;
import set.Label;

import java.util.List;

public class Qualifier extends LinguisticVariable {

    private boolean simple;

    public Qualifier(String name, List<Label> labels, UniverseOfDiscourse universeOfDiscourse) {
        super(name, labels, universeOfDiscourse);
    }

//    public Qualifier(UniverseOfDiscourse universeOfDiscourse, List<Tag> tag) {
//        super(universeOfDiscourse, tag);
//    }

}
