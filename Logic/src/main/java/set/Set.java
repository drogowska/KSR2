package set;

import java.util.List;

public abstract class Set<T> {


    public List<T> values;

    public List<T> getValues() {
        return values;
    }
    public abstract Set<T> sum(Set<T> set);
    public abstract Set<T> multiply(Set<T> set);
    public abstract Set<T> complement();

    public abstract Set<T> and(Set<T> set);

    public abstract Set<T> or(Set<T> set);

}
