package set;
import functions.MembershipFunction;


public class Tag {

    private String label;
    private MembershipFunction membershipFunctions;

    public Tag(MembershipFunction membershipFunctions) {
        this.membershipFunctions = membershipFunctions;
    }

    public Tag(String label, MembershipFunction membershipFunctions) {
        this.label = label;
        this.membershipFunctions = membershipFunctions;
    }

    public boolean contains(Double x) {
        if (membershipFunctions.getUniverseOfDiscourse().contain(x))
            return true;
        return false;
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
