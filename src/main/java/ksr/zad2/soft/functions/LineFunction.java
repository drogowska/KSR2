package ksr.zad2.soft.functions;

import ksr.zad2.soft.set.ClassicSet;

public class LineFunction extends MembershipFunction{
    //y =ax+b
    private final double a;
    double b;

    public LineFunction(double a, double b, UniverseOfDiscourse universe) {
        super(universe);
        universeOfDiscourse = universe;
        this.a = a;
        this.b = b;
    }


    public double getX(double y) {
        return (y - b) / a;
    }
    @Override
    public int calculate(double x) {
        double y = a*x+b;
        return (y <= 0)? 0 : (int) y;
    }
}
