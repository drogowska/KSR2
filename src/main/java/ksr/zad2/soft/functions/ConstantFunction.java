package ksr.zad2.soft.functions;

import ksr.zad2.soft.set.ClassicSet;

public class ConstantFunction extends LineFunction {
    public ConstantFunction(UniverseOfDiscourse universe) {
        super(0, -1, universe);
    }

    @Override
    public int calculate(double x) {
        return 1;
    }
}
