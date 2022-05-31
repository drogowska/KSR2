package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.functions.UniverseOfDiscourse;
import ksr.zad2.soft.set.FuzzySet;
import lombok.Getter;

import static ksr.zad2.soft.SoftApplication.database;

@Getter
public class FuzzyQuantifier extends FuzzySet {

    private boolean isAbsolute;

    public FuzzyQuantifier(String label, MembershipFunction membershipFunctions) {
        super(label, membershipFunctions, new UniverseOfDiscourse(0, database.size()));
    }

    public FuzzyQuantifier(String label, MembershipFunction membershipFunctions, boolean isAbsolute) {
        this(label, membershipFunctions);
        this.isAbsolute = isAbsolute;
    }

    public boolean isAbsolute() {
        return isAbsolute;
    }
}
