package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.set.FuzzySet;

public class Quantifier<T> extends FuzzySet<T> {

    private String quantifierName;

    public Quantifier(String quantifierName, MembershipFunction membershipFunction) {
        super(membershipFunction);
        this.quantifierName = quantifierName;
    }

    public String getQuantifierName() {
        return quantifierName;
    }
}
