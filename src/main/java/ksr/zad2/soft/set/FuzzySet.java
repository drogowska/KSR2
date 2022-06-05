package ksr.zad2.soft.set;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.functions.MembershipFunction;

import java.util.List;

public class FuzzySet<T> extends Set<T> {

    protected MembershipFunction membershipFunction;

    public FuzzySet(MembershipFunction membershipFunction) {
        super();
        this.membershipFunction = membershipFunction;
    }

    public MembershipFunction getMembershipFunction() {
        return membershipFunction;
    }

    public float getDegreeOfFuzziness(List<CustomRecord> record, AttributeEnum columnName) {
        long suppSize = record.stream().filter(r -> membershipFunction.calculate(AttributeEnum.getValue(r, columnName)) > 0).count();
        return (float)suppSize / (float)record.size();
    }
}
