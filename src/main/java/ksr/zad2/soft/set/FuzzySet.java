package ksr.zad2.soft.set;

import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.data.SpeedDatingRecord;
import ksr.zad2.soft.functions.*;
import lombok.Getter;

import java.util.*;

@Getter
public class FuzzySet<T> {

    protected boolean isNormal;
    protected boolean isConvex;
    private boolean isEmpty;

    ClassicSet<T> universe;
    MembershipFunction<T> function;
    private String label;

    public FuzzySet(ClassicSet universe, MembershipFunction function) {
        this.universe = universe;
        this.function = function;
    }

    public FuzzySet(String label, MembershipFunction<T> function, ClassicSet<T> cutDB) {
        this.label = label;
        this.function = function;
        this.universe = cutDB;
    }

    public ClassicSet getAlphaCut(List<T> list, double a) {
//        if (universe.isDiscrete) {
            List<T> l = new ArrayList<>();
            for (T i : list) {
                if (function.calculate(i) > a)
                    l.add(i);
            }
            return new ClassicSet(l);
//        }
//        return null;
    }

    public ClassicSet supp(List<T> list) {
        return getAlphaCut(list, 0);
    }

//    public double sum(FuzzySet set, double v) {
//        return Math.min(function.calculate(v),set.function.calculate(v));
//    }

    public double compatibility(T obj) {
        return function.calculate(obj);
    }

    private boolean isEmpty() {
        int res = 0;
        for (T v : universe)
            if (function.calculate(v) > 0) res++;
        return (res == universe.size());
    }

    public Double getHeight() {
        List<Double> values = new ArrayList<>();
        for (T d : universe) {
            values.add(function.calculate(d));
        }
        return Collections.max(values);
    }

    public double and(FuzzySet<T> set, T obj) {
        return Math.min(set.compatibility(obj), this.compatibility(obj));
    }
    public double or(FuzzySet<T> set, T obj) {
        return Math.max(set.compatibility(obj), this.compatibility(obj));
    }
    public FuzzySet or(FuzzySet set) {
        return null;
    }

    public double sigmaCount(List<T> list) {
        double res = 0;
        if (!universe.isDiscrete)
            System.out.println("to do");
            // to calka
        else {
            for (T i : list)
                res += function.calculate(i);
        }
        return res;
    }

    //degree of fuzziness
    public Double in(List<T> list) {
        return (double) (supp(list).size() / list.size());
    }

//
//    public FuzzySet multiply(FuzzySet set) {
//        HashMap<Object, Double> values = new HashMap<>();
//        for (Object i : universe) {
//            values.put(i, Math.max(map.get(i),set.map.get(i)));
//        }
//        return new FuzzySet(values);
//    }
//
//    public FuzzySet complement() {
//        HashMap<Object, Double> values = new HashMap<>();
//        for (Object i : universe) {
//            values.put(i, 1-map.get(i));
//        }
//        return new FuzzySet(values);
//    }
//
//    public double compatibilityLevel(Object x) {
//        return map.get(x);
////        int id = this.x.indexOf(x);
////        return y.get(id);
//    }
//

//
//        return res;
//    }
//
//    public FuzzySet and(FuzzySet set) {
//        return (FuzzySet) multiply(set);
//    }
//
//    public double and(FuzzySet set, double r) {
//        return Math.min(set.function.calculate(r), this.function.calculate(r));
//    }
//
////    @Override
//    public FuzzySet or(FuzzySet set) {
//        return null;
////      //  ClassicSet uni = (ClassicSet) set.universe.sum(this.universe);
////        List<Double> list = new ArrayList<>();
////        for (int i = 0; i < uni.x.size(); i++) {
////            list.add((set.y.get(i) != 0 && 0 == y.get(i))? set.y.get(i) : y.get(i));
////        }
////        return new FuzzySet(uni.x, list);
//    }
//


}
