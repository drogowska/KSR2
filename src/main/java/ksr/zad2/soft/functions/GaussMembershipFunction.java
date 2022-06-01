package ksr.zad2.soft.functions;

import ksr.zad2.soft.set.ClassicSet;

public class GaussMembershipFunction<T> extends MembershipFunction<T> {
    private final double center;
    private final double width;

    public GaussMembershipFunction(ValueExtractor<T> extractor, double center, double width, ClassicSet universe) {
        super(universe, extractor);
        if (width == 0)
            throw new IllegalArgumentException("Width in Gauss function can't be 0!");
        denseUniverse = universe;
        this.center = center;
        this.width = width;
    }
    @Override
    public double calculate(T x) {
        double z = extractor.apply(x);
        double y = Math.pow(Math.exp((-1 * (z-center)) / width), 2);
        return (y <= 0 && y > 1)? 0 : (double) y;
    }



}
