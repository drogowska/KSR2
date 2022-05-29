package ksr.zad2.soft.fuzzy;
import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.set.FuzzySet;

public class Label {

    private String label;
    private MembershipFunction membershipFunctions;
    private FuzzySet fuzzy;

    public Label(MembershipFunction membershipFunctions) {
        this.membershipFunctions = membershipFunctions;
    }

    public Label(String label, MembershipFunction membershipFunctions) {
        this.label = label;
        this.membershipFunctions = membershipFunctions;
        this.fuzzy = new FuzzySet(membershipFunctions.getUniverseOfDiscourse(), membershipFunctions);
    }

    public boolean contains(Double x) {
        return membershipFunctions.getUniverseOfDiscourse().contain(x);
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
