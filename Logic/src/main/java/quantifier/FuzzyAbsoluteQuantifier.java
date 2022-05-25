package quantifier;

import functions.UniverseOfDiscourse;
import set.Tag;

import java.util.List;

public class FuzzyAbsoluteQuantifier extends FuzzyQuantifier {
    public FuzzyAbsoluteQuantifier(UniverseOfDiscourse universeOfDiscourse, List<Tag> tag) {
        super(universeOfDiscourse, tag);
    }

    public boolean isAbsolute() {
        return true;
    }
}
