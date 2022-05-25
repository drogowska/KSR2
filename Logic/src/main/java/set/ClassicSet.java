package set;

import functions.UniverseOfDiscourse;

import java.util.Collections;
import java.util.List;

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
    public Set sum(Set set) {
        return null;
    }

    @Override
    public Set multiply(Set set) {
        return null;
    }

    @Override
    public Set complement(Set set) {
        return null;
    }

    @Override
    public Set and(Set... set) {
        return null;
    }

    @Override
    public Set or(Set... set) {
        return null;
    }
}
