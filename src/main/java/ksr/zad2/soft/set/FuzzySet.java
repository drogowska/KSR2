package ksr.zad2.soft.set;

import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.data.SpeedDatingRecord;
import ksr.zad2.soft.functions.*;
import lombok.Getter;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

import static ksr.zad2.soft.SoftApplication.cutDB;

@Getter
public class FuzzySet {

    protected boolean isNormal;
    protected boolean isConvex;
    private boolean isEmpty;
    UniverseOfDiscourse<Double> universe;
    MembershipFunction function;
    HashMap<SpeedDatingRecord, Double> map = new HashMap<>();
    private String label;

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

    public FuzzySet(String label, MembershipFunction function, UniverseOfDiscourse universe) {
        this.function = function;
        this.universe = universe;
        this.label = label;
    }

    public FuzzySet(UniverseOfDiscourse universe, MembershipFunction function) {
        this.universe = universe;
//        this.x = universe.x;
        this.function = function;
//        x.forEach(xs -> y.add(function.calculate(xs)));
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
    }

    public FuzzySet(UniverseOfDiscourse universe, MembershipFunction function, SpeedDatingRecord record) {
        this.universe = universe;
//        this.x = universe.x;
        this.function = function;
//        x.forEach(xs -> y.add(function.calculate(xs)));
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
    }
    public double getValue(Double x) {
        return function.calculate(x);
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
        for (int v : universe)
            if (function.calculate(v) > 0) res++;
        return (res == universe.size());
    }

    public FuzzySet(UniverseOfDiscourse universeOfDiscourse, HashMap<Double, Double> valXY) {
        this.universe = universeOfDiscourse;
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
    }

//    public ClassicSet getAlphaCut(double alpha) {
//        List<Integer> tagsList = new ArrayList<>();
//        for (int i = 0; i < universe.size(); i++ ){
//            if (function.calculate(universe.get(i)) >= alpha) {
//                tagsList.add(universe.get(i));
//            }
//        }
//        return new ClassicSet(tagsList);
//    }
    public ClassicSet<CustomRecord> getAlphaCut(double alpha) {
        List<CustomRecord> tagsList = new ArrayList<>();
        for (CustomRecord customRecord : cutDB) {
            if (function.calculate(map.get(customRecord)) >= alpha) {
                tagsList.add(customRecord);
            }
        }
        return new ClassicSet<CustomRecord>(tagsList);
    }

    public ClassicSet getSupp() {
        return getAlphaCut(0);
    }

    public Double getHeight() {
        return Collections.max(map.values());
    }

    public FuzzySet sum(FuzzySet set) {
        return null;
//        UniverseOfDiscourse<Integer> uni = new UniverseOfDiscourse(
//                (set.getUniverse().getMin() >= this.universe.getMin())? set.getUniverse().getMin() : this.universe.getMin(),
//                (set.getUniverse().getMax() >= this.universe.getMax())? this.universe.getMax() : set.getUniverse().getMax());
//        for (int i = 0; i < uni.size(); i++) {
//            if (uni.get(i))
//        }
////        List<Double> values = new ArrayList<>();
////        for (int i = 0; i <universe.size(); i++)
////            values.add(Math.min(function.calculate(universe.get(i)), set.function.calculate(set.universe.get(i))));
////        return x -> Math.min(this.getFunction().calculate(x), set.getFunction().calculate(x));
//
//        new FuzzySet(uni, values);
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

    public double compatibilityLevel(CustomRecord x) {
        return map.get(x);
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
        return Double.valueOf(getSupp().size() / map.size());
    }

}
