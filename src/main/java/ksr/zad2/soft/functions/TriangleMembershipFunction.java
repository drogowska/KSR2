package ksr.zad2.soft.functions;

import java.util.List;

public class TriangleMembershipFunction<T> extends TrapezoidalMembershipFunction<T> {
    public TriangleMembershipFunction(ValueExtractor<T> extractor,int minX, int maxYx, int maxX) {
        super(extractor,minX, maxYx, maxYx, maxX);
    }
}
