package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.AttributeEnum;
import ksr.zad2.soft.set.FuzzySet;

public class Qualifier<T> extends FuzzySet<T> {

    private AttributeEnum columnName;
    private String labelName;

    public Qualifier(Label label, AttributeEnum columnName) {
        super(label.getFuzzySet().getMembershipFunction());
        this.columnName = columnName;
        this.labelName = label.getLabelName();
    }

    public AttributeEnum getColumnName() {
        return columnName;
    }

    public String getLabel() {
        return labelName;
    }
}
