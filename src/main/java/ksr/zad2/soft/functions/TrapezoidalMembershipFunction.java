package ksr.zad2.soft.functions;

import java.util.ArrayList;
import java.util.List;

public class TrapezoidalMembershipFunction extends MembershipFunction {
    private List<LineFunction> funs = new ArrayList<>();

    public TrapezoidalMembershipFunction(int minX, int maxYs, int maxYe, int maxX) {
        super(new UniverseOfDiscourse(minX, maxX), false);
        if (minX - maxYs != 0 && maxX - maxYe != 0) {
            funs.add(new LineFunction( 1/(maxYs - minX), -1*minX / (maxYs - minX), new UniverseOfDiscourse(minX, maxYs)));
            funs.add(new ConstantFunction(new UniverseOfDiscourse(maxYs, maxYe)));
            funs.add(new LineFunction(-1 / (maxX - maxYe), -1*maxX / (maxYe - maxX), new UniverseOfDiscourse(maxYe, maxX)));
        } else if (minX - maxYs == 0) {
            funs.add(new ConstantFunction(new UniverseOfDiscourse(minX, maxYe)));
            funs.add(new LineFunction(-1 / (maxX - maxYe), -1*maxX / (maxYe - maxX), new UniverseOfDiscourse(maxYe, maxX)));
        } else {
            funs.add(new LineFunction(-1 / (minX - maxYs), -1*minX / (maxYs - minX), new UniverseOfDiscourse(minX, maxYs)));
            funs.add(new ConstantFunction(new UniverseOfDiscourse(maxYs, maxYe)));
        }

    }

    public int calculate(double x) {
        for (LineFunction fun : funs) {
            if (fun.universeOfDiscourse.contains(x))
                return (fun.calculate(x) <= 0)? 0: fun.calculate(x);
        }
        return 0;
    }
}
