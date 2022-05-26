package fuzzy;

import functions.UniverseOfDiscourse;
import set.FuzzySet;
import set.Label;

import java.util.List;

public class Summarizer extends FuzzySet {

    boolean isCompound;
    String V;    //ex. age
    public Summarizer(UniverseOfDiscourse universeOfDiscourse, List<Label> label) {
        super(universeOfDiscourse, label);
    }



}
