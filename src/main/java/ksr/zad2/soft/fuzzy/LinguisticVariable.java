package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.AttributeEnum;

import java.util.List;

public class LinguisticVariable {

    private AttributeEnum column;
    private List<Label> labels;

    public LinguisticVariable(AttributeEnum column, List<Label> label) {
        this.column = column;
        this.labels = label;
    }
}
