package functions;

import java.util.ArrayList;
import java.util.List;

public class TrapezoidalMembershipFunction extends MembershipFunction {
    private List<LineFunction> funs = new ArrayList<>();

    public TrapezoidalMembershipFunction(double a1, double b1, double a3, double b3, UniverseOfDiscourse universe) {
        this.universeOfDiscourse = universe;
        LineFunction F1 = new LineFunction(a1, b1, universeOfDiscourse);
        LineFunction F2 = new LineFunction(a3, b3, universeOfDiscourse);
        double constMin = F1.getX(1);
        double constMax = F2.getX(0);
        funs.add(F1);
        funs.add(new ConstantFunction(universe.split(constMin, constMax)));
        funs.add(F2);
    }

    public Double calculate(double x) {
        for (LineFunction fun : funs) {
            if (fun.getUniverseOfDiscourse().contain(x))
                return fun.calculate(x);
        }
        return null;
    }
}
