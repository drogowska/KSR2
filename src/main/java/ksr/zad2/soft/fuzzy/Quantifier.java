package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.defined.DefinedLinguisticVariables;
import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.set.FuzzySet;

public class Quantifier<T> extends FuzzySet<T> {

    private String quantifierName;
    private boolean isAbsolute;

    public Quantifier(String quantifierName, MembershipFunction membershipFunction, boolean isAbsolute) {
        super(0, DefinedLinguisticVariables.database_size, isAbsolute ? membershipFunction : membershipFunction.denormalized());
        this.quantifierName = quantifierName;
        this.isAbsolute = isAbsolute;
    }

    public String getQuantifierName() {
        return quantifierName;
    }

    public String toString() {
        return quantifierName;
    }

    public boolean isAbsolute() {
        return isAbsolute;
    }

    public void setAbsolute(boolean absolute) {
        isAbsolute = absolute;
    }
}
