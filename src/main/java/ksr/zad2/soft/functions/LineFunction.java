package ksr.zad2.soft.functions;

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
    public Double calculate(double x) {
        return a*x +b;
    }
}
