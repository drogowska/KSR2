package ksr.zad2.soft.functions;

public class TriangularMembershipFunction extends MembershipFunction<Float> {

    private float a;
    private float b;
    private float c;

    public TriangularMembershipFunction(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public float calculate(Float x) {
        if(x <= a || c <= x) {
            return 0;
        }
        if(x == b) {
            return 1;
        }
        if(a <= x && x <= b) {
            return (x - a) / (b - a);
        }
        if(b <= x && x <= c) {
            return (x - c) / (b - c);
        }
        return 0;
    }

    @Override
    public float getSupport() {
        return c - a;
    }

    @Override
    public float getCardinality() {
        return (c - a)/2;
    }
}
