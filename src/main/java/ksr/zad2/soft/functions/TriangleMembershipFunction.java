package functions;

import java.util.List;

public class TriangleMembershipFunction extends TrapezoidalMembershipFunction {


//    public TriangleMembershipFunction(double a1, double b1, double a2, double b2, List<UniverseOfDiscourse> universe) {
////        super(universe.get(0));
//        universeOfDiscourse = universe.get(0);
//        universeOfDiscourse.sum(universe.get(1));
//        fun1 = new LineFunction(a1,b1,universe.get(0));
//        fun2 = new LineFunction(a2,b2,universe.get(1));
//        setValues();
//    }

    public TriangleMembershipFunction(double minX, double maxYx, double maxX) {
        super(minX, maxYx, maxYx, maxX);
//        fun1 = new LineFunction(-1 / (minX - maxYx), 1 /(maxYx - minX), new UniverseOfDiscourse(minX, maxYx, 1.0));
//        fun2 = new LineFunction(-1 / (maxYx - maxX), 1 / (maxYx - maxX), new UniverseOfDiscourse(maxYx, maxX, 1.0));
//        setValues();
    }

//    public Double calculate(double x) {
//        if (fun1.getUniverseOfDiscourse().contain(x))
//            return fun1.calculate(x);
//        else if (fun2.getUniverseOfDiscourse().contain(x))
//            return fun2.calculate(x);
//        return 0.0;
//    }
}
