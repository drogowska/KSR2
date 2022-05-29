package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.functions.UniverseOfDiscourse;
import lombok.Getter;
import ksr.zad2.soft.set.FuzzySet;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CompoundVariable extends LinguisticVariable {

    List<String> connectives = new ArrayList<>();
    FuzzySet fset;

    public CompoundVariable(String name, List<Label> labels, UniverseOfDiscourse universeOfDiscourse) {
        super(name, labels, universeOfDiscourse);
    }

    public CompoundVariable(List<Label> labels, List<String> connectives) {
        super("compound", labels, new UniverseOfDiscourse(labels.get(0).getMembershipFunctions().getUniverseOfDiscourse().getMin(),
                labels.get(1).getMembershipFunctions().getUniverseOfDiscourse().getMax(), 1));
        this.connectives = connectives;
        compound();

    }

    public FuzzySet compound() {
        List<FuzzySet> fuzzySet = new ArrayList<>();
        labels.forEach(l -> fuzzySet.add(l.getFuzzy()));
        int k =0;
        for (int i = 1; i < fuzzySet.size(); i += 2) {
            FuzzySet f = (connectives.get(k).equals("and"))?
                    labels.get(i-1).getFuzzy().and(labels.get(i).getFuzzy()) :
                    labels.get(i-1).getFuzzy().or(labels.get(i).getFuzzy());
            k++;
            fuzzySet.add(i+1, f);
        }
        fset = fuzzySet.get(fuzzySet.size()+connectives.size()-1);
        name = labels.get(0).getLabel();
        for (int i = 1; i<labels.size(); i++)
            this.name += connectives.get(i-1) + labels.get(i).getLabel();
        return fset;
    }




}
