package ksr.zad2.soft.functions;

import java.util.HashMap;
import java.util.Map;

public abstract class MembershipFunction {
    UniverseOfDiscourse universeOfDiscourse;
    Map<Double, Double> map = new HashMap<>();

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
    public Map<Double, Double> getValues() {
        return map;
    }

    public abstract Double calculate(double x);
}
