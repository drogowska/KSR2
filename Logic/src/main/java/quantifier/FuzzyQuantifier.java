package quantifier;

import functions.UniverseOfDiscourse;
import set.FuzzySet;

import java.util.List;

public abstract class FuzzyQuantifier extends FuzzySet {

    private int form;

    public boolean isNormal() {
        //height = 1
        return false;
    }

    public boolean isConvex() {
        //if every alpha cut is convex
        return false;
    }

    public abstract boolean isAbsolute();
}
