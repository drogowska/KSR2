package ksr.zad2.soft.functions;
import ksr.zad2.soft.set.ClassicSet;

public class GaussMembershipFunction extends MembershipFunction {
    private final double center;
    private final double width;

    public GaussMembershipFunction(double center, double width, UniverseOfDiscourse universe) {
        super(universe);
        if (width == 0)
            throw new IllegalArgumentException("Width in Gauss function can't be 0!");
        universeOfDiscourse = universe;
        this.center = center;
        this.width = width;
    }

    public int calculate(double x) {
        double y = Math.pow(Math.exp((-1 * (x-center)) / width), 2);
        return (y <= 0)? 0 : (int) y;
    }
}
