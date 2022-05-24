package functions;

import functions.MembershipFunction;

public class TriangleMembershipFunction extends MembershipFunction {

   private LineFunction fun1;
    private LineFunction fun2;

    public TriangleMembershipFunction(double a1, double b1, double a2, double b2, UniverseOfDiscourse universe) {
        universeOfDiscourse = universe;
        fun1 = new LineFunction(a1,b1,universeOfDiscourse);
        fun2 = new LineFunction(a2,b2,universeOfDiscourse);
    }

    public Double calculate(double x) {
        if (fun1.getUniverseOfDiscourse().contain(x))
            return fun1.calculate(x);
        else if (fun2.getUniverseOfDiscourse().contain(x))
            return fun2.calculate(x);
        return 0.0;
    }
}
