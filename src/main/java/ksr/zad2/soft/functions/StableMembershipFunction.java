package ksr.zad2.soft.functions;

import ksr.zad2.soft.defined.DefinedLinguisticVariables;

public class StableMembershipFunction extends MembershipFunction {

    @Override
    public float calculate(Object o) {
        return 1;
    }

    @Override
    public float getSupport() {
        return DefinedLinguisticVariables.database_size;
    }

    @Override
    public float getCardinality() {
        return DefinedLinguisticVariables.database_size;
    }

    @Override
    public MembershipFunction denormalized() {
        return this;
    }
}
