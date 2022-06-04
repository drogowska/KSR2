package ksr.zad2.soft.functions;

import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.set.ClassicSet;
import ksr.zad2.soft.set.DenseClassicSet;

import java.util.ArrayList;
import java.util.List;

public class TrapezoidalMembershipFunction<T> extends MembershipFunction<T> {
    private List<LineFunction> funs = new ArrayList<>();

    public TrapezoidalMembershipFunction(ValueExtractor<T> extractor,int minX, int maxYs, int maxYe, int maxX) {
        super(new DenseClassicSet(minX, maxX), extractor);
        if (minX - maxYs != 0 && maxX - maxYe != 0) {
            funs.add(new LineFunction( extractor, (double) 1 / (maxYs - minX), (double) -1*minX / (maxYs - minX), new DenseClassicSet(minX, maxYs)));
            funs.add(new ConstantFunction(new ClassicSet(maxYs, maxYe)));
            funs.add(new LineFunction(extractor,(double) -1 / (maxX - maxYe), (double) -1*maxX / (maxYe - maxX), new DenseClassicSet(maxYe, maxX)));
        } else if (minX - maxYs == 0) {
            funs.add(new ConstantFunction(new DenseClassicSet(minX, maxYe)));
            double d = (double) -1 / (maxX - maxYe);
            funs.add(new LineFunction(extractor,d, (double) -1 * maxX / (maxYe - maxX), new DenseClassicSet(maxYe, maxX)));
        } else {
            funs.add(new LineFunction(extractor,(double) -1 / (minX - maxYs),(double)  -1*minX / (maxYs - minX), new DenseClassicSet(minX, maxYs)));
            funs.add(new ConstantFunction(new DenseClassicSet(maxYs, maxYe)));
        }

    }

    public double calculate(T x) {
        double z = extractor.apply(x);
        for (LineFunction fun : funs) {
            if (z >= fun.denseUniverse.getBegin() && z<= fun.denseUniverse.getEnd())
                return (fun.calculate(x) <= 0 && fun.calculate(x) > 1)? 0: fun.calculate(x);
        }
        return 0;
    }
}
