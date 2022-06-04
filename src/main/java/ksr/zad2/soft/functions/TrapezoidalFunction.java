package ksr.zad2.soft.functions;

public class TrapezoidalFunction implements MembershipFunction<Double> {

    private double a;
    private double b;
    private double c;
    private double d;

    public TrapezoidalFunction(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double calculate(Double x) {
        if(x <= a || d <= x) {
            return 0;
        }
        if(b <= x && x <= c) {
            return 1;
        }
        if(c <= x && x <= d) {
            return (x - d) / (c - b);
        }
        if(a <= x && x <= b) {
            return (x - a) / (b - a);
        }
        return 0;
    }
}
