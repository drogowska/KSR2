package quantifier;

import functions.UniverseOfDiscourse;
import set.Label;

import java.util.List;

public class FuzzyRelativeQuantifier extends FuzzyQuantifier {
    public FuzzyRelativeQuantifier(UniverseOfDiscourse universeOfDiscourse, List<Label> label) {
        super(universeOfDiscourse, label);
    }

    public boolean isAbsolute() {
        return false;
    }
}
