package ksr.zad2.soft.functions;

import ksr.zad2.soft.set.ClassicSet;
import lombok.Getter;

@Getter
public abstract class MembershipFunction<T> {
    ClassicSet denseUniverse;
    ValueExtractor<T> extractor;
    double height;
    double support = 0.0;
    double clm = 0.0;
    public MembershipFunction(ClassicSet denseUniverse) {
        this.denseUniverse = denseUniverse;
    }

    public MembershipFunction(ClassicSet denseUniverse, ValueExtractor<T> extractor) {
        this.denseUniverse = denseUniverse;
        this.extractor = extractor;
    }

    public abstract double calculate(T x);
}
