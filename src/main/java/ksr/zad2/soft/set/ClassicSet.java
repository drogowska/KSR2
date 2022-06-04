package ksr.zad2.soft.set;

import lombok.Getter;

import java.util.*;

@Getter
public class ClassicSet<T> extends ArrayList<T> {

    protected double begin;
    protected double end;
    protected boolean isDiscrete;
    public ClassicSet() {
        super();
    }

    public ClassicSet(double begin, double end) {
        this.begin = begin;
        this.end = end;
    }

    public ClassicSet(List<T> values) {
        super(values);
        this.isDiscrete = true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClassicSet{");
        sb.append('}');
        return sb.toString();
    }

    public ClassicSet sum(ClassicSet u) {
        List<T> val = new ArrayList<>(this);
        val.addAll(u);
        return new ClassicSet(new ArrayList<>(new HashSet<>(val)));
    }

    public ClassicSet multiply(ClassicSet set) {
        List<T> list = new ArrayList<>();
        for (T d : this) {
            if (set.contains(d))
                list.add(d);
        }
        return new ClassicSet(list);
    }

    public boolean isEmpty() {
        if (isDiscrete)
            return this.isEmpty();
        return begin - end > 0;
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

    public double getBegin() {
        return begin;
    }

    public double getEnd() {
        return end;
    }

    public boolean isDiscrete() {
        return isDiscrete;
    }
}
