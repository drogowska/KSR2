package ksr.zad2.soft.functions;

public class TrapezoidalFunction extends MembershipFunction<Float> {

    private float a;
    private float b;
    private float c;
    private float d;

    public TrapezoidalFunction(float a, float b, float c, float d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public float calculate(Float x) {
        if(x <= a || d <= x) {
            return 0;
        }
        if(b <= x && x <= c) {
            return 1;
        }
        if(c <= x && x <= d) {
            return (float)((x - d) / (c - b));
        }
        if(a <= x && x <= b) {
            return (float)((x - a) / (b - a));
        }
        return 0;
    }

    @Override
    public float getSupport() {
        return d - a;
    }

    @Override
    public float getCardinality() {
        return ((d - a) + (c - b))/2;
    }
}
