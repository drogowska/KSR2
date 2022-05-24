package functions;

import jdk.javadoc.internal.doclets.toolkit.util.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UniverseOfDiscourse {
    private UniverseOfDiscourseType universeOfDiscourseType;
    private List<Double> discreetDomain;
    private List<Utils.Pair<Double, Double>> denseDomain;
    boolean isDense = true;

    UniverseOfDiscourse(List<Double> discreetDomain, boolean dense) {
        this.universeOfDiscourseType = UniverseOfDiscourseType.DENSE;
        this.discreetDomain = discreetDomain;
        this.isDense = dense;
    }

    UniverseOfDiscourse(List<Utils.Pair<Double, Double>> denseDomain) {
        this.universeOfDiscourseType = UniverseOfDiscourseType.DISCREET;
        this.denseDomain = denseDomain;
    }

    public boolean contain(Double x) {
        if (discreetDomain.contains(x))
            return true;
        return false;
    }
}
