package set;

import functions.UniverseOfDiscourse;
import quantifier.Tag;

import java.util.List;

public abstract class Set {
    UniverseOfDiscourse universeOfDiscourse;
    protected Tag tag;

    public abstract Set sum(Set set);
    public abstract Set multiply(Set set);
    public abstract Set complement(Set set);

    public abstract Set and(Set... set);

    public abstract Set or(Set... set);

    public abstract Set not() ;
}
