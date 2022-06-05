package ksr.zad2.soft.set;

import ksr.zad2.soft.functions.MembershipFunction;

public class FuzzySet<T> extends Set<T> {

    protected MembershipFunction membershipFunction;

    public FuzzySet(MembershipFunction membershipFunction) {
        super();
        this.membershipFunction = membershipFunction;
    }

    public MembershipFunction getMembershipFunction() {
        return membershipFunction;
    }

    public float getDegreeOfFuzziness() {
        long suppSize = this.stream().filter(t -> membershipFunction.calculate(t) > 0).count();
        return (float)suppSize / (float)this.size();
    }
}
