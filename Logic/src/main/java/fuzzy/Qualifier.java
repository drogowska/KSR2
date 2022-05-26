package fuzzy;

import functions.UniverseOfDiscourse;
import set.FuzzySet;
import set.FuzzySetType;
import set.Tag;

import java.util.List;

public class Qualifier extends FuzzySet {

    private boolean simple;

    public Qualifier(UniverseOfDiscourse universeOfDiscourse, List<Tag> tag) {
        super(universeOfDiscourse, tag);
    }

}
