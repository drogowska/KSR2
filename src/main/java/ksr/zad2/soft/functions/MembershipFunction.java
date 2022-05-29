package functions;

import java.util.HashMap;

public abstract class MembershipFunction {
    UniverseOfDiscourse universeOfDiscourse;
    HashMap<Double, Double> map;

    public UniverseOfDiscourse getUniverseOfDiscourse() {
        return universeOfDiscourse;
    }

    public MembershipFunction(UniverseOfDiscourse universeOfDiscourse) {
        this.universeOfDiscourse = universeOfDiscourse;
        setValues();
    }

    public void setValues() {
        universeOfDiscourse.x.forEach(d -> map.put(d, calculate(d)));
    }
    public HashMap<Double, Double> getValues() {
        return map;
    }

    public abstract Double calculate(double x);
}
