package set;

import functions.UniverseOfDiscourse;
import quantifier.Tag;

import java.util.List;

public abstract class Set {
    private UniverseOfDiscourse universeOfDiscourse;
    private List<Tag> tags;

    public abstract Set sum(Set set);
    public abstract Set multiply(Set set);
    public abstract Set getComplement(Set set);
}
