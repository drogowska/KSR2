package ksr.zad2.soft.fuzzy;
import ksr.zad2.soft.atributes.Extractor;
import ksr.zad2.soft.data.SpeedDatingRecord;
import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.functions.UniverseOfDiscourse;
import ksr.zad2.soft.set.FuzzySet;

import java.util.HashMap;
import static ksr.zad2.soft.SoftApplication.database;

public class Label {

    private String label;
    private MembershipFunction membershipFunctions;
    FuzzySet fuzzy;
    HashMap<SpeedDatingRecord, Double> map = new HashMap<>();


    public Label(MembershipFunction membershipFunctions) {
        this.membershipFunctions = membershipFunctions;
    }

    public Label(String label, UniverseOfDiscourse universe, MembershipFunction membershipFunctions) {
        this.label = label;
        this.membershipFunctions = membershipFunctions;
        this.fuzzy = new FuzzySet(universe, membershipFunctions);
//        database.forEach(d -> map.put(d, membershipFunctions.calculate(Extractor::extract(d))));
    }
    public Label(String label, MembershipFunction membershipFunctions) {
        this.label = label;
        this.membershipFunctions = membershipFunctions;
//        this.fuzzy = new FuzzySet(new UniverseOfDiscourse<>(), membershipFunctions);
//        database.forEach(d -> map.put(d, membershipFunctions.calculate(Extractor::extract(d))));
    }

    public boolean contains(Double x) {
        return membershipFunctions.getUniverseOfDiscourse().contains(x);
    }

    public FuzzySet getFuzzy() {
        return fuzzy;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public MembershipFunction getMembershipFunctions() {
        return membershipFunctions;
    }

    public void setMembershipFunctions(MembershipFunction membershipFunctions) {
        this.membershipFunctions = membershipFunctions;
    }
}
