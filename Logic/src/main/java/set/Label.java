package set;
import functions.MembershipFunction;


public class Label {

    private String label;
    private MembershipFunction membershipFunctions;

    public Label(MembershipFunction membershipFunctions) {
        this.membershipFunctions = membershipFunctions;
    }

    public Label(String label, MembershipFunction membershipFunctions) {
        this.label = label;
        this.membershipFunctions = membershipFunctions;
    }

    public boolean contains(Double x) {
        return membershipFunctions.getUniverseOfDiscourse().contain(x);
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
