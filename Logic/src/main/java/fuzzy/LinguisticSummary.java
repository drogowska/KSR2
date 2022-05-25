package fuzzy;

import data.Subject;
import quantifier.FuzzyQuantifier;

import java.util.List;

public class LinguisticSummary {

    private FuzzyQuantifier quantifier;  //Q
    private List<Qualifier> qualifiers;  //W
    private List<Summarizer> summarizers; //S
    private List<Subject> subjects;  //P1
    private List<Subject> subjects2;  //P2

    private double T;

    private boolean withQualifier;

    private int form;
    private SummaryType summaryType;


    //degree of truth
    public double T1() {
        if (quantifier.isAbsolute()) {
//            return quantifier.cop
        }
        return 0.0;
    }
    //degree of imprecision
    public double T2() {
        return 0.0;
    }

    //degree of fuzziness
    private double in() {
        return 0;
    }



    //degree of covering
    public static double T3() {
        return  0.0;
    }
    //degree of appropriateness
    public static double T4() {
        return 0;
    }

    //length of a summary
    public static double T5() {
        return 0;
    }
    //the optimal summary
    public static double T() {
        return 0;
    }

    //degree of quantifier imprecision
    public static double T6() {
        return 0;
    }
    //degree of quantifier cardinality
    public static double T7() {
        return 0;
    }
    //degree of summarizer cardinality
    public static double T8() {
        return 0;
    }
    //degree of qualifier imprecision
    public static double T9() {
        return 0;
    }
    //degree of qualifier cardinality
    public static double T10() {
        return 0;
    }
    //length of a qualifier
    public static double T11() {
        return 0;
    }


}
