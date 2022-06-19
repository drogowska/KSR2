package ksr.zad2.soft.set;

import ksr.zad2.soft.functions.MembershipFunction;

import java.util.stream.Collectors;

public class FuzzySet<T> extends Set<T> {

    protected MembershipFunction membershipFunction;

    /*public FuzzySet(MembershipFunction membershipFunction) {
        super();
        this.membershipFunction = membershipFunction;
    }*/

    public FuzzySet(float xStart, float xEnd, MembershipFunction membershipFunction) {
        super(xStart, xEnd);
        this.membershipFunction = membershipFunction;
    }

    public MembershipFunction getMembershipFunction() {
        return membershipFunction;
    }

    public float getDegreeOfFuzziness() {
        float suppSize = membershipFunction.getSupport();
        return suppSize / (getXEnd() - getXStart());
    }

    public boolean isConvex() {
        return true;
    }

    public boolean isEmpty() {
        return isEmpty();
    }

    public boolean isNormal() {
        return true;
    }

    public float getHeight() {
        return 0;
    }

    public Set<T> getSupp() {
        return this.stream().filter(x -> membershipFunction.calculate(x) > 0).collect(Collectors.toCollection(Set::new));
    }

    public Set<T> getAlphaCut(float alpha) {
        return null;
    }
}
