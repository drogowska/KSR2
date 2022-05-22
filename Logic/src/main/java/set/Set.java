package set;

import functions.UniverseOfDiscourse;
import quantifier.Tag;

import java.util.List;

public abstract class Set {
    private UniverseOfDiscourse universeOfDiscourse;
    private Tag tag;

    public abstract Set sum(Set set);
    public abstract Set multiply(Set set);
    public abstract Set complement(Set set);

    public abstract Set and(FuzzySet... set);

    public abstract Set or(FuzzySet... set);

    public abstract Set not() ;
}
