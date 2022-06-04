package ksr.zad2.soft.fuzzy;

import java.util.List;

public class LinguisticVariable {

    private String columnName;
    private List<Label> labels;

    public LinguisticVariable(String columnName, List<Label> label) {
        this.columnName = columnName;
        this.labels = label;
    }
}
