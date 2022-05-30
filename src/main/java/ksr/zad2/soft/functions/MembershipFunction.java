package ksr.zad2.soft.functions;

import ksr.zad2.soft.set.ClassicSet;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Getter
public abstract class MembershipFunction {
    UniverseOfDiscourse universeOfDiscourse;

    public MembershipFunction(UniverseOfDiscourse universeOfDiscourse) {
        this.universeOfDiscourse = universeOfDiscourse;
    }

    public MembershipFunction(UniverseOfDiscourse universeOfDiscourse, boolean setValues) {
        this.universeOfDiscourse = universeOfDiscourse;
    }


    public abstract Double calculate(double x);
}
