package functions;

public class LineFunction extends MembershipFunction{
    //y =ax+b
    private double a;
    double b;

    public LineFunction(double a, double b, UniverseOfDiscourse universe) {
        super();
        setUniverse(universe);
        this.a = a;
        this.b = b;
    }

    public void setUniverse(UniverseOfDiscourse universe) {
        double minX = (-1 * b) / a;
        double maxX = (1 - b) / a;
        if (minX != maxX)
            universeOfDiscourse = universe.split(minX,maxX);
        else

    }

    public double getX(double y) {
        return (y - b) / a;
    }



    @Override
    public Double calculate(double x) {
        return a*x +b;
    }
}
