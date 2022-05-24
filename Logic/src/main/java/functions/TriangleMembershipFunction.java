package functions;

import functions.MembershipFunction;

public class TriangleMembershipFunction extends MembershipFunction {

    private double a1;
    private double b1;
    private double a2;
    private double b2;
    private LineFunction fun1;
    private LineFunction fun2;

    public TriangleMembershipFunction(double a1, double b1, double a2, double b2) {
       fun1 = new LineFunction(a1,b1);
       fun2 = new LineFunction(a2,b2);
    }

    public Double calculate(double x) {
        if (fun1.getUniverseOfDiscourse().contain(x))
            return fun1.calculate(x);
        else if (fun2.getUniverseOfDiscourse().contain(x))
            return fun2.calculate(x);
        return 0.0;
    }
}
