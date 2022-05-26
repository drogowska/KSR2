package fuzzy;

import data.Record;
import lombok.Getter;
import quantifier.FuzzyQuantifier;
import set.FuzzySet;
import set.Tag;

import java.util.List;

@Getter
public class LinguisticSummary {

    private FuzzyQuantifier quantifier;  //Q
    private List<FuzzySet> qualifiers;  //W
    private List<FuzzySet> summarizers; //S
    private List<Record> subjects;  //P1
    private List<Record> subjects2;  //P2

    private List<Record> objects;  //rekordy z bazy

    private boolean withQualifier;

    private int form;
    private SummaryType summaryType;
    private List<Double> wages;


    //degree of truth
    public double T1() {
        if (summaryType.equals(SummaryType.ONESUBJECT)) {
            if (quantifier.isAbsolute())
                return quantifier.compatibilityLevel(summarizers.get(0).sigmaCount());
            else {
                FuzzySet sumSet = (FuzzySet) summarizers.get(0).sum(summarizers.get(1));
                return quantifier.compatibilityLevel(
                        sumSet.sigmaCount() / summarizers.get(1).sigmaCount());
            }
        }
        return 0.0;
    }

    private double r(FuzzySet set, double x) {
        double suma = 0.0;
        for (Tag t : set.values) {
            suma += t.getMembershipFunctions().calculate(x);
        }
        return suma;
    }
    //degree of imprecision
    public double T2() {
        return imprecision(summarizers);
    }

    private double imprecision(List<FuzzySet> set) {
        Double mul = 0.0;
        for (FuzzySet s : set)
            mul *= s.in();
        return 1 - Math.pow(mul, set.size());
    }

    //degree of covering
    public static double T3() {
        return  0.0;
    }
    //degree of appropriateness
    public double T4() {
        return 0;
    }

    //length of a summary
    public double T5() {
        return length(summarizers);
    }
    //the optimal summary
    public double T(List<Double> wages) {
        return wages.get(0) * T1() +
                wages.get(1) * T2() +
                wages.get(2) * T3() +
                wages.get(3) * T4() +
                wages.get(4) * T5() +
                wages.get(5) * T6() +
                wages.get(6) * T7() +
                wages.get(7) * T8() +
                wages.get(8) * T9() +
                wages.get(9) * T10() +
                wages.get(10) * T11();
    }

    //degree of quantifier imprecision
    public double T6() {
        if (quantifier.isAbsolute())
            return 1 - quantifier.getSupp().values.size() / objects.size();
        return 1 - quantifier.in();
    }
    //degree of quantifier cardinality
    public double T7() {
        if (quantifier.isAbsolute()) {
            return 1 - quantifier.sigmaCount() / objects.size();
        }
        return 1 - quantifier.sigmaCount();
    }
    //degree of summarizer cardinality
    public double T8() {
       return cardinality(summarizers);
    }
    //degree of qualifier imprecision
    public double T9() {
        return imprecision(qualifiers);
    }
    //degree of qualifier cardinality
    public double T10() {
        return cardinality(qualifiers);
    }

    private double length(List<FuzzySet> set) {
        return 2 * Math.pow(0.5, set.size());
    }
    private double cardinality(List<FuzzySet> set) {
        Double mul = 0.0;
        for (FuzzySet s : set)
            mul *= s.sigmaCount() / s.getUniverseOfDiscourse().values.size();
        return 1 - Math.pow(mul, set.size());
    }
    //length of a qualifier
    public double T11() {
        return length(qualifiers);
    }


}
