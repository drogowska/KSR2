package quantifier;

import functions.MembershipFunction;
import lombok.Getter;
import fuzzy.Label;

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

}
