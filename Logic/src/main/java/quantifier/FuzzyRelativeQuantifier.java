package quantifier;

import functions.UniverseOfDiscourse;
import set.Tag;

import java.util.List;

public class FuzzyRelativeQuantifier extends FuzzyQuantifier {
    public FuzzyRelativeQuantifier(UniverseOfDiscourse universeOfDiscourse, List<Tag> tag) {
        super(universeOfDiscourse, tag);
    }

    public boolean isAbsolute() {
        return false;
    }
}
