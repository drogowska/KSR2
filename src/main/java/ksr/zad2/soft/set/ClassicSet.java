package ksr.zad2.soft.set;

import ksr.zad2.soft.functions.UniverseOfDiscourse;

import java.util.*;

public class ClassicSet<T> extends ArrayList<T> {




//    public ClassicSet(UniverseOfDiscourse universe, List<Double> values) {
//        this. = universe;
//        function = new ConstantFunction(universe);
////        this.x = values;
//    }

    public ClassicSet() {
        super();
    }

    public ClassicSet(List<T> values) {
    }

//    public T getMin() {
//        return Collections.min(this);
//    }
//
//
//    public T getMax() {
//        return Collections.max(this);
//    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassicSet{");
        sb.append('}');
        return sb.toString();
    }

//    @Override
//    public Set sum(Set set) {
//        return new ClassicSet(universe.sum(set.getUniverse()));
//    }

    public ClassicSet sum(ClassicSet u) {
        List<T> val = new ArrayList<>(this);
        val.addAll(u);
        return new ClassicSet(new ArrayList<>(new HashSet<>(val)));
    }
//część wspólna
    public ClassicSet multiply(ClassicSet set) {
        List<T> list = new ArrayList<>();
        for (T d : this) {
            if (set.contains(d))
                list.add(d);
        }
        return new ClassicSet(list);
    }

    public ClassicSet complement() {
        List<T> list = new ArrayList<>();
        for (T d : this) {
            if (!this.contains(d))
                list.add(d);
        }
        return new ClassicSet(list);
    }

    public ClassicSet and(ClassicSet set) {
        return multiply(set);
    }

    public ClassicSet or(ClassicSet set) {
        List<T> list = new ArrayList<>();
        for (T d : this) {
            if (!set.contains(d))
                list.add(d);
        }
        return new ClassicSet(list);
    }

}
