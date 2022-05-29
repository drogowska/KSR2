package ksr.zad2.soft.quantifier;

import ksr.zad2.soft.functions.MembershipFunction;
import lombok.Getter;
import ksr.zad2.soft.fuzzy.Label;

@Getter
public class FuzzyQuantifier extends Label {

    private boolean isAbsolute;

    public FuzzyQuantifier(MembershipFunction membershipFunctions) {
        super(membershipFunctions);
    }

    public FuzzyQuantifier(String label, MembershipFunction membershipFunctions) {
        super(label, membershipFunctions);
    }

    public FuzzyQuantifier(String label, MembershipFunction membershipFunctions, boolean isAbsolute) {
        super(label, membershipFunctions);
        this.isAbsolute = isAbsolute;
    }

    //    public FuzzyQuantifier(UniverseOfDiscourse universeOfDiscourse, List<Label> label) {
//        super(universeOfDiscourse, label);
//    }


    public boolean isAbsolute() {
        return isAbsolute;
    }
}
