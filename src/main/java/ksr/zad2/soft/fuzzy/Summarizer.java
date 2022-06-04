package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.set.FuzzySet;

public class Summarizer<T> extends FuzzySet<T> {

    private String columnName;
    private String labelName;

    public Summarizer(Label label, String columnName) {
        super(label.getFuzzySet().getMembershipFunction());
        this.columnName = columnName;
        this.labelName = label.getLabelName();
    }

    public String getColumnName() {
        return columnName;
    }

    public String getLabel() {
        return labelName;
    }
}
