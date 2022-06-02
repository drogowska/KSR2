package ksr.zad2.soft.set;

import java.util.List;

public class DenseClassicSet extends ClassicSet<Double> {

    public DenseClassicSet(int begin, int end) {
        super(begin, end);
        for (double i = begin; i < end; i++)
            this.add(i);
    }

    public DenseClassicSet(List<Integer> values) {
        this.isDiscrete = true;
        for (int v : values)
            this.add((double)v);
    }

    public int begin() {
        return (int) begin;
    }

    public int end() {
        return (int) end;
    }
}
