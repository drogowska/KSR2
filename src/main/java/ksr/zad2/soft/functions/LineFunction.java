package ksr.zad2.soft.functions;

import ksr.zad2.soft.set.ClassicSet;
import lombok.Getter;

@Getter
public class LineFunction<T> extends MembershipFunction<T>{
    //y =ax+b
    public Double a;
    public Double b;

    public LineFunction(ValueExtractor<T> extractor, Double a, Double b, ClassicSet universe) {
        super(universe, extractor);
        denseUniverse = universe;
        this.a = a;
        this.b = b;
    }


    public double getX(double y) {
        return (y - b) / a;
    }
    @Override
    public double calculate(T x) {
        double z = extractor.apply(x);
        double y = a*z+b;
        return (y <= 0 && y > 1)? 0 : y;
    }
}
