package ksr.zad2.soft.functions;

import ksr.zad2.soft.set.ClassicSet;

public class ConstantFunction<T> extends LineFunction<T> {
    public ConstantFunction(ClassicSet universe) {
        super(null,0.0, -1.0, universe);
    }

    @Override
    public double calculate(T x) {
        return 1.0;
    }
}
