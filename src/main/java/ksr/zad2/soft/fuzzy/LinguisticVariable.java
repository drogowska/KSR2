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

    public List<Label> getLabels() {
        return labels;
    }

    public void addNewLabel(Label label) {
        labels.add(label);
    }

    public Label getLabel(int i) {
        return labels.get(i);
    }

    public AttributeEnum getColumn() {
        return column;
    }
}
