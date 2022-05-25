package quantifier;

import functions.UniverseOfDiscourse;
import set.FuzzySet;
import set.FuzzySetType;
import set.Tag;

import java.util.List;

public abstract class FuzzyQuantifier extends FuzzySet {

    private int form;

    public FuzzyQuantifier(UniverseOfDiscourse universeOfDiscourse, List<Tag> tag) {
        super(universeOfDiscourse, tag);
    }

    public boolean isNormal() {
        //height = 1
        return isNormal;
    }

    public boolean isConvex() {
        //if every alpha cut is convex
        return isConvex;
    }

    public abstract boolean isAbsolute();
}
