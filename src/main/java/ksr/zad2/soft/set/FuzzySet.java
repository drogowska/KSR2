package ksr.zad2.soft.set;

import ksr.zad2.soft.functions.*;
import ksr.zad2.soft.fuzzy.Label;
import lombok.Getter;

import java.util.*;
@Getter
public class FuzzySet extends Set<Double> {

    protected boolean isNormal;
    protected boolean isConvex;
    private boolean isEmpty;

    public FuzzySet(UniverseOfDiscourse universeOfDiscourse) {
        super();
        this.universe = universeOfDiscourse;
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
//        isConvex = (isConvex());
    }


    public FuzzySet(UniverseOfDiscourse universe, MembershipFunction function) {
        this.universe = universe;
        this.x = universe.x;
        x.forEach(xs -> y.add(function.calculate(xs)));
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
    }

    public FuzzySet(UniverseOfDiscourse universe, List<Double> ys) {
        this.universe = universe;
        this.x = universe.x;
        y = ys;
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
    }

    public FuzzySet(List<Double> xs, List<Double> ys) {
        x = xs;
        y = ys;
        universe = new UniverseOfDiscourse(Collections.min(xs), Collections.max(xs), 1);
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
    }

    public UniverseOfDiscourse getUniverseOfDiscourse() {
        return universe;
    }

    //to do
    private boolean isConvex() {
        return false;
    }

    private boolean isEmpty() {
        int res = 0;
        for (Double v : y)
            if (v > 0) res++;
        return (res == x.size());
    }

    public FuzzySet(UniverseOfDiscourse universeOfDiscourse, HashMap<Double, Double> valXY) {
        this.universe = universeOfDiscourse;
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
    }

    public ClassicSet getAlphaCut(double alpha) {
        List<Double> tagsList = new ArrayList<>();
        for (int i = 0; i < y.size(); i++ ){
            if (y.get(i) >= alpha)
                tagsList.add(x.get(i));
        }
        return new ClassicSet(universe, tagsList);
    }

    public ClassicSet getSupp() {
        return getAlphaCut(0);
    }

    public Double getHeight() {
        return Collections.max(y);
    }

    @Override
    public Set<Double> sum(Set<Double> set) {
        ClassicSet uni = (ClassicSet) set.universe.sum(this.universe);
        List<Double> values = new ArrayList<>();
        for (int i = 0; i <uni.x.size(); i++)
            values.add(Math.min(y.get(i), set.y.get(i)));
        return new FuzzySet(uni.x, values);
    }
    @Override
    public Set<Double> multiply(Set<Double> set) {
        ClassicSet uni = (ClassicSet) set.universe.sum(this.universe);
        List<Double> values = new ArrayList<>();
        for (int i = 0; i <uni.x.size(); i++) {
            values.add(Math.max(y.get(i), set.y.get(i)));
        }
        return new FuzzySet(uni.x, values);
    }

    @Override
    public Set<Double> complement() {
        List<Double> labels = new ArrayList<>();
        for (int i = 0; i < x.size(); i++)
            labels.add(1-y.get(i));
        return new FuzzySet(universe.x, labels);
    }

    public double compatibilityLevel(double x) {
        int id = this.x.indexOf(x);
        return y.get(id);
    }
    public double sigmaCount() {
        double res = 0;
        for (Double i : y)
            res += i;
        return res;
    }
    @Override
    public FuzzySet and(Set<Double> set) {
        return (FuzzySet) multiply(set);
    }

    @Override
    public FuzzySet or(Set<Double> set) {
        ClassicSet uni = (ClassicSet) set.universe.sum(this.universe);
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < uni.x.size(); i++) {
            list.add((set.y.get(i) != 0 && 0 == y.get(i))? set.y.get(i) : y.get(i));
        }
        return new FuzzySet(uni.x, list);
    }

    //degree of fuzziness
    public Double in() {
        return Double.valueOf(getSupp().x.size() / universe.x.size());
    }

}
