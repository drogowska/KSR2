package quantifier;

import functions.UniverseOfDiscourse;
import set.FuzzySet;
import set.Label;

import java.util.List;

public abstract class FuzzyQuantifier extends FuzzySet {

    private int form;

    public FuzzyQuantifier(UniverseOfDiscourse universeOfDiscourse, List<Label> label) {
        super(universeOfDiscourse, label);
    }

    public abstract boolean isAbsolute();
}
