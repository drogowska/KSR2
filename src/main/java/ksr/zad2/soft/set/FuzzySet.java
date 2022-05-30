package ksr.zad2.soft.set;

import ksr.zad2.soft.data.SpeedDatingRecord;
import ksr.zad2.soft.functions.*;
import lombok.Getter;

import java.util.*;
@Getter
public class FuzzySet<T> {

    protected boolean isNormal;
    protected boolean isConvex;
    private boolean isEmpty;
    UniverseOfDiscourse<Double> universe;
    MembershipFunction function;


    public void setUniverse(UniverseOfDiscourse universe) {
        this.universe = universe;
    }

    public FuzzySet(UniverseOfDiscourse universeOfDiscourse) {
        super();
        this.universe = universeOfDiscourse;
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
//        isConvex = (isConvex());
    }


    public FuzzySet(UniverseOfDiscourse universe, MembershipFunction function) {
        this.universe = universe;
//        this.x = universe.x;
        this.function = function;
//        x.forEach(xs -> y.add(function.calculate(xs)));
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
    }

    public FuzzySet(UniverseOfDiscourse universe, List<Double> ys) {
        this.universe = universe;
//        this = universe;
//        y = ys;
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
    }

    public FuzzySet(List<Double> xs, List<Double> ys) {
//        x = xs;
//        y = ys;
//        universe = new UniverseOfDiscourse(Collections.min(xs), Collections.max(xs), 1);
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
        for (Double v : universe)
            if (function.calculate(v) > 0) res++;
        return (res == universe.size());
    }

    public FuzzySet(UniverseOfDiscourse universeOfDiscourse, HashMap<Double, Double> valXY) {
        this.universe = universeOfDiscourse;
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
    }

    public ClassicSet getAlphaCut(double alpha) {
        List<Double> tagsList = new ArrayList<>();
        for (int i = 0; i < universe.size(); i++ ){
            if (function.calculate((Double) universe.get(i)) >= alpha)
                tagsList.add((Double) universe.get(i));
        }
        return new ClassicSet(tagsList);
    }

    public ClassicSet getSupp() {
        return getAlphaCut(0);
    }

    public Double getHeight() {
        return 0.0;//Collections.max(function.calculate(0.0));
    }

//    @Override
    public FuzzySet sum(FuzzySet set) {
        return null;
       // ClassicSet uni = (ClassicSet) set.universe.sum(this.universe);
//        List<Double> values = new ArrayList<>();
//        for (int i = 0; i <universe.size(); i++)
//            values.add(Math.min(function.calculate(universe.get(i)), set.function.calculate(set.universe.get(i))));
//        return new FuzzySet(set.universe, values);
    }

    public FuzzySet multiply(FuzzySet set) {
        return null;
      //  ClassicSet uni = (ClassicSet) set.universe.sum(this.universe);
//        List<Double> values = new ArrayList<>();
//        for (int i = 0; i <set.x.size(); i++) {
//            values.add(Math.max(y.get(i), set.y.get(i)));
//        }
//        return new FuzzySet(set.x, values);
    }

    public FuzzySet complement() {
        return null;
//        List<Double> labels = new ArrayList<>();
//        for (int i = 0; i < x.size(); i++)
//            labels.add(1-y.get(i));
//        return new FuzzySet(universe, labels);
    }

    public double compatibilityLevel(double x) {
        return 0;
//        int id = this.x.indexOf(x);
//        return y.get(id);
    }

    public double sigmaCount() {
        double res = 0;
//        for (Double i : y) {
//            res += i;
//        }
        return res;
    }

    public FuzzySet and(FuzzySet set) {
        return (FuzzySet) multiply(set);
    }

    public double and(FuzzySet set, double r) {
        return Math.min(set.function.calculate(r), this.function.calculate(r));
    }

//    @Override
    public FuzzySet or(FuzzySet set) {
        return null;
//      //  ClassicSet uni = (ClassicSet) set.universe.sum(this.universe);
//        List<Double> list = new ArrayList<>();
//        for (int i = 0; i < uni.x.size(); i++) {
//            list.add((set.y.get(i) != 0 && 0 == y.get(i))? set.y.get(i) : y.get(i));
//        }
//        return new FuzzySet(uni.x, list);
    }

    //degree of fuzziness
    public Double in() {
        return 0.0;//Double.valueOf(getSupp().x.size() / universe.x.size());
    }

}
