package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.set.FuzzySet;

public class Label<T> {

    private String labelName;
    private FuzzySet<T> fuzzySet;

    public Label(String labelName, FuzzySet<T> fuzzySet) {
        this.labelName = labelName;
        this.fuzzySet = fuzzySet;
    }

    public String getLabelName() {
        return labelName;
    }

    public FuzzySet<T> getFuzzySet() {
        return fuzzySet;
    }

}
