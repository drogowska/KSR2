package ksr.zad2.soft.functions;

import java.util.List;

public class TriangleMembershipFunction extends TrapezoidalMembershipFunction {
    public TriangleMembershipFunction(double minX, double maxYx, double maxX) {
        super(minX, maxYx, maxYx, maxX);
    }
}
