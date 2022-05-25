package set;

import functions.UniverseOfDiscourse;

import java.util.*;

public class ClassicSet extends Set<Double> {
    private UniverseOfDiscourse universe;

    public ClassicSet(List<Double> values) {
        super();
        this.values = values;
        universe = null;
    }

    public ClassicSet(List<Double> universe, List<Double> values) {
        super();
        this.values = values;
        this.universe = new UniverseOfDiscourse(universe);
    }

    public ClassicSet(UniverseOfDiscourse universe, List<Double> values) {
        this.universe = universe;
        this.values = values;
    }

    public ClassicSet() {
        super();
    }
    public Double getMin() {
        return Collections.min(values);
    }

    public UniverseOfDiscourse getUniverse() {
        return universe;
    }

    public Double getMax() {
        return Collections.max(values);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassicSet{");
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Set<Double> sum(Set<Double> set) {
        HashSet<Double> val = new HashSet<>(values);
        val.addAll(set.values);
        return new ClassicSet((List<Double>) val);
    }
//część wspólna
    @Override
    public Set<Double> multiply(Set<Double> set) {
        List<Double> list = new ArrayList<>();
        for (Double d : values) {
            if (set.values.contains(d))
                list.add(d);
        }
        return new ClassicSet(list);
    }

    @Override
    public Set<Double> complement() {
        List<Double> list = new ArrayList<>();
        for (Double d : universe.getValues()) {
            if (!this.values.contains(d))
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
        for (Double d : values) {
            if (!set.values.contains(d))
                list.add(d);
        }
        return new ClassicSet(list);
    }
}
