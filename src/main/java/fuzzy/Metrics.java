package fuzzy;

import set.FuzzySet;

public class Metrics {

    //degree of truth
    public static double T1(LinguisticSummary summary) {
        return 0.0;
    }
    //degree of imprecision
    public static double T2(LinguisticSummary summary) {
        return 0.0;
    }

    //degree of fuzziness
    private static double in(FuzzySet A) {
        return 0;
    }

    private static double sigmaCount(FuzzySet A) {
        return 0;
    }

    //degree of covering
    public static double T3(LinguisticSummary summary) {
        return  0.0;
    }
    //degree of appropriateness
    public static double T4(LinguisticSummary summary) {
        return 0;
    }

    //length of a summary
    public static double T5(LinguisticSummary summary) {
        return 0;
    }
    //the optimal summary
    public static double T(LinguisticSummary summary) {
        return 0;
    }

    //degree of quantifier imprecision
    public static double T6(LinguisticSummary summary) {
        return 0;
    }
    //degree of quantifier cardinality
    public static double T7(LinguisticSummary summary) {
        return 0;
    }
    //degree of summarizer cardinality
    public static double T8(LinguisticSummary summary) {
        return 0;
    }
    //degree of qualifier imprecision
    public static double T9(LinguisticSummary summary) {
        return 0;
    }
    //degree of qualifier cardinality
    public static double T10(LinguisticSummary summary) {
        return 0;
    }
    //length of a qualifier
    public static double T11(LinguisticSummary summary) {
        return 0;
    }

}
