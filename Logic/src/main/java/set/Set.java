package set;

import java.util.List;

public abstract class Set<T> {


    public List<T> values;

    public List<T> getValues() {
        return values;
    }
    public abstract Set sum(Set set);
    public abstract Set multiply(Set set);
    public abstract Set complement(Set set);

    public abstract Set and(Set... set);

    public abstract Set or(Set... set);

}
