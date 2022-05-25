package functions;

public class GaussMembershipFunction extends MembershipFunction {
    private double center;
    private double width;

    public GaussMembershipFunction(double center, double width, UniverseOfDiscourse universe) {
        super(universe);
        if (width == 0)
            throw new IllegalArgumentException("Width in Gauss function can't be 0!");
        universeOfDiscourse = universe;
        this.center = center;
        this.width = width;
    }

    public Double calculate(double x) {
        return Math.pow(Math.exp((-1 * (x-center)) / width), 2);
    }
}
