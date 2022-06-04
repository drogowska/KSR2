package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.set.FuzzySet;

public class Summarizer<T> extends FuzzySet<T> {

    private AttributeEnum columnName;
    private String labelName;
    private ConnectiveEnum connective;

    public Summarizer(Label label, AttributeEnum columnName, ConnectiveEnum connective) {
        super(label.getFuzzySet().getMembershipFunction());
        this.columnName = columnName;
        this.labelName = label.getLabelName();
        this.connective = connective;
    }

    public AttributeEnum getColumnName() {
        return columnName;
    }

    public String getLabel() {
        return labelName;
    }

    public ConnectiveEnum getConnective() {
        return connective;
    }
}
