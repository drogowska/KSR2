package ksr.zad2.soft.functions;

public class GaussMembershipFunction extends MembershipFunction<Float> {

    float center;
    float halfOfWidth;

    public GaussMembershipFunction(float center, float halfOfWidth) {
        this.center = center;
        this.halfOfWidth = halfOfWidth;
    }

    @Override
    public float calculate(Float x) {
        if(x <= center - halfOfWidth || center + halfOfWidth <= x) {
            return 0;
        }
        if(center - halfOfWidth <= x && x <= center + halfOfWidth) {
            return (float) Math.exp(-1 * Math.pow((x - center) / (halfOfWidth / 2), 2));
        }
        return 0;
    }

    @Override
    public float getSupport() {
        return 2 * halfOfWidth;
    }

    @Override
    public float getCardinality() {
        return (float) ((halfOfWidth / 2) * Math.pow(Math.PI, 0.5d));
    }
}
