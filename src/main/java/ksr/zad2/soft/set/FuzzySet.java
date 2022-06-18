package ksr.zad2.soft.set;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.functions.MembershipFunction;

import java.util.List;
import java.util.stream.Collectors;

public class FuzzySet<T> extends Set<T> {

    protected MembershipFunction membershipFunction;

    public FuzzySet(MembershipFunction membershipFunction) {
        super();
        this.membershipFunction = membershipFunction;
    }

    public FuzzySet(float xStart, float xEnd, MembershipFunction membershipFunction) {
        super(xStart, xEnd);
        this.membershipFunction = membershipFunction;
    }

    public MembershipFunction getMembershipFunction() {
        return membershipFunction;
    }

    public float getDegreeOfFuzziness(List<CustomRecord> record, AttributeEnum columnName) {
        long suppSize = record.stream().filter(r -> membershipFunction.calculate(AttributeEnum.getValue(r, columnName)) > 0).count();
        return (float)suppSize / (getxEnd() - getxStart());
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
