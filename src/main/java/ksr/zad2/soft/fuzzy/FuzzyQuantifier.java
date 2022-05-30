package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.functions.UniverseOfDiscourse;
import lombok.Getter;
import ksr.zad2.soft.fuzzy.Label;

import static ksr.zad2.soft.SoftApplication.database;

@Getter
public class FuzzyQuantifier extends Label {

    private boolean isAbsolute;

    public FuzzyQuantifier(MembershipFunction membershipFunctions) {
        super(membershipFunctions);
    }

    public FuzzyQuantifier(String label, MembershipFunction membershipFunctions) {
        super(label, (UniverseOfDiscourse) membershipFunctions.getUniverseOfDiscourse(), membershipFunctions);
        this.fuzzy.setUniverse(new UniverseOfDiscourse(0, database.size()));
    }

    public FuzzyQuantifier(String label, MembershipFunction membershipFunctions, boolean isAbsolute) {
        super(label, (UniverseOfDiscourse) membershipFunctions.getUniverseOfDiscourse(), membershipFunctions);
        this.isAbsolute = isAbsolute;
    }



    public boolean isAbsolute() {
        return isAbsolute;
    }
}
