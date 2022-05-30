package ksr.zad2.soft.set;

import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.functions.UniverseOfDiscourse;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Getter
public abstract class Set {
//
//    public List<Double> x = new ArrayList<>();
//    public List<Double> y = new ArrayList<>();
    UniverseOfDiscourse universe;
    MembershipFunction function;

    public List<Double> getValues() {
        return universe;
    }
    public abstract Set sum(Set set);
    public abstract Set multiply(Set set);
    public abstract Set complement();

    public abstract Set and(Set set);

    public abstract Set or(Set set);

}
