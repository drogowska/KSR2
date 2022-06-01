package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.set.ClassicSet;
import lombok.Getter;
import ksr.zad2.soft.set.FuzzySet;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CompoundVariable extends LinguisticVariable<CustomRecord> {

    List<String> connectives = new ArrayList<>();
    FuzzySet fset;

    public CompoundVariable(String name, List<FuzzySet<CustomRecord>> labels, ClassicSet denseUniverse) {
        super(name, labels, denseUniverse);
    }

    public CompoundVariable(List<FuzzySet<CustomRecord>> labels, List<String> connectives) {
        super("compound", labels, new ClassicSet(labels.get(0).getUniverse().sum(
                labels.get(1).getUniverse())));
        this.connectives = connectives;
        compound();
    }

    public CompoundVariable(FuzzySet labels) {
        super(List.of(labels));
    }

    public FuzzySet compound() {
        List<FuzzySet> fuzzySet = new ArrayList<>();
        fuzzySet.addAll(labels);
        int k =0;
        for (int i = 1; i < fuzzySet.size(); i += 2) {
            FuzzySet f = (connectives.get(k).equals("and")) ?
                    labels.get(i-1).and(labels.get(i)) :
                    labels.get(i-1).or(labels.get(i));
            k++;
            fuzzySet.add(i+1, f);
        }
        fset = fuzzySet.get(fuzzySet.size()-1);
        name = labels.get(0).getLabel();
        for (int i = 1; i<labels.size(); i++)
            this.name += " " + connectives.get(i-1) + " " + labels.get(i).getLabel();
        return fset;
    }




}
