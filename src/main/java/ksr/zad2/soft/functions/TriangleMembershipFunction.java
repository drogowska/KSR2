package ksr.zad2.soft.functions;

import java.util.List;

public class TriangleMembershipFunction extends TrapezoidalMembershipFunction {
    public TriangleMembershipFunction(int minX, int maxYx, int maxX) {
        super(minX, maxYx, maxYx, maxX);
    }
}
