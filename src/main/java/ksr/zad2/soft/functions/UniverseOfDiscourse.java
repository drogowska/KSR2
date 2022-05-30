package ksr.zad2.soft.functions;

import lombok.Getter;
import ksr.zad2.soft.set.ClassicSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Getter
public class UniverseOfDiscourse<T> extends ClassicSet<T> implements Cloneable, Comparable<UniverseOfDiscourse> {
    private UniverseOfDiscourseType universeOfDiscourseType;
    boolean isDense = true;
    boolean finite = true;

    T min;
    T max;

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

    public UniverseOfDiscourse(List<T> values) {
        super(values);
    }

    public UniverseOfDiscourse(UniverseOfDiscourseType universeOfDiscourseType) {
        super();
        this.universeOfDiscourseType = universeOfDiscourseType;
    }

    public UniverseOfDiscourse(T min, T max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int compareTo(UniverseOfDiscourse o) {
        if (this.equals(o)) return 0;
        return -1;
    }
}
