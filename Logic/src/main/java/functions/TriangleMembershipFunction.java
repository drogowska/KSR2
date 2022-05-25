package functions;

import java.util.List;

public class TriangleMembershipFunction extends MembershipFunction {

   private LineFunction fun1;
    private LineFunction fun2;

    public TriangleMembershipFunction(double a1, double b1, double a2, double b2, List<UniverseOfDiscourse> universe) {
        super(universe.get(0));
        universeOfDiscourse = universe.get(0);
        universeOfDiscourse.sum(universe.get(1));
        fun1 = new LineFunction(a1,b1,universe.get(0));
        fun2 = new LineFunction(a2,b2,universe.get(1));
        setValues();
    }

    public Double calculate(double x) {
        if (fun1.getUniverseOfDiscourse().contain(x))
            return fun1.calculate(x);
        else if (fun2.getUniverseOfDiscourse().contain(x))
            return fun2.calculate(x);
        return 0.0;
    }
}
