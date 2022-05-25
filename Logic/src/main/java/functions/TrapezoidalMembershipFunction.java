package functions;

import java.util.ArrayList;
import java.util.List;

public class TrapezoidalMembershipFunction extends MembershipFunction {
    private List<LineFunction> funs = new ArrayList<>();

    public TrapezoidalMembershipFunction(double a1, double b1, double a3, double b3, List<UniverseOfDiscourse> universe) {
        super(universe.get(0));
        this.universeOfDiscourse = universe.get(0);
        for(UniverseOfDiscourse u : universe) {
            this.universeOfDiscourse.sum(u);
        }
        LineFunction F1 = new LineFunction(a1, b1, universe.get(0));
        LineFunction F2 = new LineFunction(a3, b3, universe.get(2));
        funs.add(F1);
        funs.add(new ConstantFunction(universe.get(1)));
        funs.add(F2);
        setValues();
    }

    public Double calculate(double x) {
        for (LineFunction fun : funs) {
            if (fun.getUniverseOfDiscourse().contain(x))
                return fun.calculate(x);
        }
        return null;
    }
}
