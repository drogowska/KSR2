package ksr.zad2.soft.functions;

import lombok.Getter;
import ksr.zad2.soft.set.ClassicSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
@Getter
public class UniverseOfDiscourse<T> extends ClassicSet<Integer> implements Cloneable, Comparable<UniverseOfDiscourse> {
    private UniverseOfDiscourseType universeOfDiscourseType;
    boolean isDense = true;
    boolean finite = true;

    Integer min;
    Integer max;

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

    public UniverseOfDiscourse(List<Integer> values) {
        super(values);
    }

    public UniverseOfDiscourse(UniverseOfDiscourseType universeOfDiscourseType) {
        super();
        this.universeOfDiscourseType = universeOfDiscourseType;
    }

    public UniverseOfDiscourse(Integer min, Integer max) {
        this.min = min;
        this.max = max;
        for (int i = (int) min; i <= (int) max; i+=1) {
            this.add(i);
        }
    }

    @Override
    public int compareTo(UniverseOfDiscourse o) {
        if (this.equals(o)) return 0;
        return -1;
    }
}
