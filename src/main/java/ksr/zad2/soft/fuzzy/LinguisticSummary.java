package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.data.SpeedDatingRecord;
import ksr.zad2.soft.functions.Extractor;
import ksr.zad2.soft.set.FuzzySet;
import lombok.Getter;

import java.util.List;

import static ksr.zad2.soft.SoftApplication.database;

@Getter
public class LinguisticSummary {

    private FuzzyQuantifier quantifier;  //Q
    private LinguisticVariable qualifiers;  //W
    private LinguisticVariable summarizers; //S1
    private String subject;  //P1
    private String subject2;  //P2

    private List<CustomRecord> records;
    private List<CustomRecord> subList;
    private List<CustomRecord> subList1;

    private int form;
    private SummaryType summaryType;
    private List<Double> wages;
    String string = "";

    public LinguisticSummary(FuzzyQuantifier quantifier, LinguisticVariable qualifiers, LinguisticVariable summarizers, List<SpeedDatingRecord> subjects, List<SpeedDatingRecord> subjects2, List<SpeedDatingRecord> objects, boolean withQualifier, int form, SummaryType summaryType, List<Double> wages) {
        this.quantifier = quantifier;
        this.qualifiers = qualifiers;
        this.form = form;
        this.summaryType = summaryType;
        this.wages = wages;
    }

    public LinguisticSummary(FuzzyQuantifier quantifier, LinguisticVariable summarizers, List<CustomRecord> objects, String subject) {
        this.quantifier = quantifier;
        this.summarizers = summarizers;
        this.form = 1;
        this.subject = subject;
        string = "are/have";
        records = objects;
        summaryType = SummaryType.ONESUBJECT;
//        filtered = objects.stream().filter(Record::get)
    }

    public LinguisticSummary(FuzzyQuantifier quantifier, LinguisticVariable summarizers, LinguisticVariable sum2, List<CustomRecord> objects, String subject) {
        this.quantifier = quantifier;
        this.summarizers = summarizers;
        qualifiers = sum2;
        records = objects;
        this.subject = subject;
        this.form = 2;
        string = "being";
        summaryType = SummaryType.ONESUBJECT;
//        filtered = objects.stream().filter(Record::get)
    }

    public LinguisticSummary(FuzzyQuantifier quantifier, LinguisticVariable summarizers,List<CustomRecord> subList, List<CustomRecord> sublist2, List<CustomRecord> objects, String subject, String sub2, int form) {
        this.quantifier = quantifier;
        this.summarizers = summarizers;
        this.subject = subject;
        this.subject2 = sub2;
        this.form = form;
        records = objects;
        if (form == 1)
             string = "in comparison to ";
        else if (form == 4)
            string = " than ";
        summaryType = SummaryType.MULTISUBJECTS;
        records = objects;
        this.subList = subList;
        this.subList1 = sublist2;
//        filtered = objects.stream().filter(Record::get)
    }

    public LinguisticSummary(FuzzyQuantifier quantifier, LinguisticVariable summarizers, LinguisticVariable sum2, List<CustomRecord> objects,
                             List<CustomRecord> subList, List<CustomRecord> sublist2, String subject, String s2, int form) {
        this.quantifier = quantifier;
        this.summarizers = summarizers;
        qualifiers = sum2;
        this.subject2 = s2;
        this.subList = subList;
        this.subList1 = sublist2;
        this.subject = subject;
        this.form = form;
        summaryType = SummaryType.MULTISUBJECTS;
        if (form == 3)
            string = " being ";
        else
            string = " in comparison to ";
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("LinguisticSummary{");
        sb.append(quantifier.name).append(" ").append(subject).append(" ");
        sb.append(string).append(" ");
        if ((form == 1 || form == 2)  && summaryType.equals(SummaryType.ONESUBJECT)) {
            sb.append(summarizers.getName()).append(" ");
            if (form == 2) {
                sb.append("are ").append(qualifiers.getName()).append(" ");
            }
        } else if (form == 1 && summaryType.equals(SummaryType.MULTISUBJECTS))
            sb.append(subject2).append(" are ").append(summarizers.getName());
        else if (form == 2 && summaryType.equals(SummaryType.MULTISUBJECTS))
            sb.append(subject2).append(" being ").append(qualifiers.name).append(" are ").append(summarizers.name);
        else if (form == 4 && summaryType.equals(SummaryType.MULTISUBJECTS))
            sb.append(qualifiers.name).append(" in comparison to ").append(subject2).append(" are ").append(summarizers.name);
        else if (form == 3 && summaryType.equals(SummaryType.MULTISUBJECTS))
            sb.append(subject2).append(" being ").append(qualifiers.name);
        sb.append("\n");
        return sb.toString();
    }

    //degree of truth
    public double T1() {
//        CompoundVariable q = (CompoundVariable) qualifiers;
        double a = 0;
        double b = 0;

//        CompoundVariable sumSet = (CompoundVariable) summarizers;
        if (summaryType.equals(SummaryType.ONESUBJECT)) {
            if (form == 1)
                return quantifier.compatibility(summarizers.getLabel().sigmaCount(records));
            else {
                for (CustomRecord i : records)
                     a += summarizers.getLabel().and(qualifiers.getLabel(), i);
                return a / qualifiers.getLabel().sigmaCount(records);
            }
        } else {
            switch (form) {
                case 1 : {
                    double c = summarizers.getLabel().sigmaCount(subList) / subList.size();
                    double d = summarizers.getLabel().sigmaCount(subList1) / subList1.size();
                    return quantifier.compatibility(c / (c + d));
                } case 2: {
                    double c = summarizers.getLabel().sigmaCount(subList) / subList.size();
                    for (CustomRecord i : subList1)
                        a += summarizers.getLabel().and(qualifiers.getLabel(), i);
                    a /= subList1.size();
                    return quantifier.compatibility(c / (c + a));
                } case 3 : {
                    for (CustomRecord i : subList)
                        a += summarizers.getLabel().and(qualifiers.getLabel(), i);
                    a /= subList.size();
                    double c = summarizers.getLabel().sigmaCount(subList1) / subList1.size();
                    return quantifier.compatibility(a / (c + a));
                } case 4 : {
                    return -2;
                }
            }

            System.out.println("TWO SUBJECT QUALIFIERS ARE NOT AVAILABLE RIGHT NOW");
        }
        return -1;
    }
//
//    //degree of imprecision
    public double T2() {
        return imprecision(summarizers);
    }

    private double imprecision(LinguisticVariable set) {
        Double mul = 0.0;
        for (Object s : set.getLabels())
            mul *= ((FuzzySet) s).in(records);
        return 1 - Math.pow(mul, set.getLabels().size());
    }

    //degree of covering
    public double T3() {
//        return 0;
        double t = 0, h = 0;
        for (CustomRecord r : records) {
            if (summarizers.getLabel().compatibility(r) > 0 && qualifiers.getLabel().compatibility(r) > 0)
                t++;
            if (qualifiers.getLabel().compatibility(r) > 0)
                h++;
        }
        return t/h;
//        CompoundVariable q = (CompoundVariable) qualifiers;
//        CompoundVariable sumSet = (CompoundVariable) summarizers;
//        return sumSet.compound().and(q.compound()).getSupp().size() / q.compound().getSupp().size();
    }

    //degree of appropriateness
    public double T4() {
        double t = 0;
        Double mul = 0.0;
        for (Object s : summarizers.getLabels()) {
            for (CustomRecord r : records) {
                if (((FuzzySet) s).compatibility(r) > 0)
                    t++;
            }
            mul *= (double) t / records.size();
        }
        return Math.abs(mul- T3());
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
            return 1 - quantifier.supp(quantifier.getUniverse()).size() / database.size();
        return 1 - quantifier.in(quantifier.getUniverse());
    }
    //degree of quantifier cardinality
    public double T7() {
        if (quantifier.isAbsolute()) {
            return 1 - quantifier.sigmaCount(quantifier.getUniverse()) / database.size();
        }
        return 1 - quantifier.sigmaCount(quantifier.getUniverse());
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

    private double length(LinguisticVariable set) {
        return 2 * Math.pow(0.5, set.getLabels().size());
    }
    private double cardinality(LinguisticVariable set) {
        Double mul = 0.0;
        for (Object s : set.getLabels())
            mul *= ((FuzzySet)s).sigmaCount(records) / records.size();
        return 1 - Math.pow(mul, set.getLabels().size());
    }

    //length of a qualifier
    public double T11() {
        return length(qualifiers);
    }


}
