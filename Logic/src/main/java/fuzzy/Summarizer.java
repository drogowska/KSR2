package fuzzy;

import functions.UniverseOfDiscourse;
import set.FuzzySet;
import set.FuzzySetType;
import set.Tag;

import java.util.List;

public class Summarizer extends FuzzySet {


    public Summarizer(UniverseOfDiscourse universeOfDiscourse, List<Tag> tag) {
        super(universeOfDiscourse, tag);
    }
}
