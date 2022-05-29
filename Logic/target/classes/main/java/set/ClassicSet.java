package set;

import functions.UniverseOfDiscourse;

import java.util.*;

public class ClassicSet extends Set<Double> {


    public ClassicSet(List<Double> values) {
        super();
        this.x = values;
        this.universe = null;
    }

    public ClassicSet(List<Double> universe, List<Double> values) {
        super();
        this.x = values;
        this.universe = new UniverseOfDiscourse(universe);
    }

    public ClassicSet(UniverseOfDiscourse universe, List<Double> values) {
        this.universe = universe;
        this.x = values;
    }

    public ClassicSet() {
        super();
    }
    public Double getMin() {
        return Collections.min(x);
    }

    public UniverseOfDiscourse getUniverse() {
        return universe;
    }

    public Double getMax() {
        return Collections.max(x);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassicSet{");
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Set<Double> sum(Set<Double> set) {
        HashSet<Double> val = new HashSet<>(x);
        val.addAll(set.x);
        return new ClassicSet((List<Double>) val);
    }
//część wspólna
    @Override
    public Set<Double> multiply(Set<Double> set) {
        List<Double> list = new ArrayList<>();
        for (Double d : x) {
            if (set.x.contains(d))
                list.add(d);
        }
        return new ClassicSet(list);
    }

    @Override
    public Set<Double> complement() {
        List<Double> list = new ArrayList<>();
        for (Double d : universe.getValues()) {
            if (!this.x.contains(d))
                list.add(d);
        }
        return new ClassicSet(list);
    }

    @Override
    public Set<Double> and(Set<Double> set) {
        return multiply(set);
    }

    @Override
    public Set<Double> or(Set<Double> set) {
        List<Double> list = new ArrayList<>();
        for (Double d : x) {
            if (!set.x.contains(d))
                list.add(d);
        }
        return new ClassicSet(list);
    }

    public boolean contain(Double x) {
        return this.x.contains(x);
    }
}
