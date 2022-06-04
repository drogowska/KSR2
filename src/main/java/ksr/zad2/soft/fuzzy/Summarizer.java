package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.set.FuzzySet;

public class Summarizer extends FuzzySet<Double> {

    String label;

    public Summarizer(MembershipFunction membershipFunction, String label) {
        super(membershipFunction);
        this.label = label;
    }


}
