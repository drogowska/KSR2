package functions;

public class LineFunction extends MembershipFunction{
    //y =ax+b
    private double a;
    double b;

    public LineFunction(double a, double b) {
        super();
        this.a = a;
        this.b = b;
    }

    @Override
    public Double calculate(double x) {
        return a*x +b;
    }
}
