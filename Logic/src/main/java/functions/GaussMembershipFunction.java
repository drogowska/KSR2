package functions;

public class GaussMembershipFunction extends MembershipFunction {
    private double center;
    private double width;

    public GaussMembershipFunction(double center, double width) {
        if (width == 0)
            throw new IllegalArgumentException("Width in Gauss function can't be 0!");
        this.center = center;
        this.width = width;
    }

    public Double calculate(double x) {
        return Math.pow(Math.exp((-1 * (x-center)) / width), 2);
    }
}
