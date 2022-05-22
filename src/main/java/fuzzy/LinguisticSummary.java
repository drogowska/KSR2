package fuzzy;

import data.Subject;
import quantifier.FuzzyQuantifier;

import java.util.List;

public class LinguisticSummary {

    private FuzzyQuantifier quantifier;  //Q
    private List<Qualifier> qualifiers;  //W
    private List<Summarizer> summarizers; //S
    private List<Subject> subjects;  //P
    private double T;

    private boolean withQualifier;

    private int form;
    private SummaryType summaryType;

}
