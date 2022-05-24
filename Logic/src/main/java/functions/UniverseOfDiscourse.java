package functions;

import jdk.javadoc.internal.doclets.toolkit.util.Utils;
import set.ClassicSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UniverseOfDiscourse extends ClassicSet<Double> implements Cloneable {
    private UniverseOfDiscourseType universeOfDiscourseType;
    private List<Double> discreetDomain;
    private List<Utils.Pair<Double, Double>> denseDomain;
    boolean isDense = true;

    public UniverseOfDiscourse(UniverseOfDiscourseType universeOfDiscourseType, List<Double> discreetDomain, List<Utils.Pair<Double, Double>> denseDomain) {
        this.discreetDomain = discreetDomain;
        this.denseDomain = denseDomain;
        this.universeOfDiscourseType = universeOfDiscourseType;
    }

    public UniverseOfDiscourseType getUniverseOfDiscourseType() {
        return universeOfDiscourseType;
    }

    boolean finite = true;
    //TO DO - ogranac o co kaman z gestym i dyskretnym


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

    public UniverseOfDiscourse split(double minX, double maxX) {
        List<Double> list = discreetDomain.subList(discreetDomain.indexOf(minX), discreetDomain.indexOf(maxX));
        return new UniverseOfDiscourse(this.universeOfDiscourseType, list, this.denseDomain);
    }
}
