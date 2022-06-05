package ksr.zad2.soft.functions;

import static ksr.zad2.soft.defined.DefinedLinguisticVariables.database_size;

public class TrapezoidalMembershipFunction extends MembershipFunction<Float> {

    private float a;
    private float b;
    private float c;
    private float d;

    public TrapezoidalMembershipFunction(float a, float b, float c, float d) {
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
        if(c < x && x < d) {
            return (x - d) / (c - d);
        }
        if(a < x && x < b) {
            return (x - a) / (b - a);
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

    @Override
    public MembershipFunction denormalized() {
        a = a * database_size;
        b = b * database_size;
        c = c * database_size;
        d = d * database_size;
        return this;
    }
}
