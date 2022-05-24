package functions;

import java.util.ArrayList;
import java.util.List;

public class TrapezoidalMembershipFunction extends MembershipFunction {
    private List<LineFunction> funs = new ArrayList<>();

    public TrapezoidalMembershipFunction(double a1, double b1, double b2, double a3, double b3) {
        funs.add(new LineFunction(a1, b1));
        funs.add(new ConstantFunction(b2));
        funs.add(new LineFunction(a3,b3));
    }

    public Double calculate(double x) {
        for (LineFunction fun : funs) {
            if (fun.getUniverseOfDiscourse().contain(x))
                return fun.calculate(x);
        }
        return null;
    }
}
