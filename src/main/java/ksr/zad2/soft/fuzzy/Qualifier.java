package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.set.FuzzySet;

public class Qualifier<T> extends FuzzySet<T> {

    private AttributeEnum columnName;
    private String labelName;
    ConnectiveEnum connective;

    public Qualifier(Label label, AttributeEnum columnName, ConnectiveEnum connective) {
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

    @Override
    public String toString() {
        return columnName.name() + " " + labelName;
    }
}
