package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.set.FuzzySet;

public class Qualifier<T> extends FuzzySet<T> {

    private AttributeEnum columnName;
    private Label orgLabel;
    private String labelName;
    ConnectiveEnum connective;

    public Qualifier(Label label, AttributeEnum columnName, ConnectiveEnum connective) {
        super(label.getFuzzySet().getXStart(), label.getFuzzySet().getXEnd(), label.getFuzzySet().getMembershipFunction());
        this.columnName = columnName;
        this.orgLabel = label;
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

    public void setConnective(ConnectiveEnum connective) {
        this.connective = connective;
    }

    @Override
    public String toString() {
        return columnName.name() + " " + labelName;
    }

    public Qualifier copy() {
        return new Qualifier(orgLabel, columnName, connective);
    }
}
