package ksr.zad2.soft.fuzzy;

import ksr.zad2.soft.data.CustomRecord;
import ksr.zad2.soft.set.ClassicSet;
import ksr.zad2.soft.set.FuzzySet;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Getter
public class LinguisticVariable<T> {

    String name;             //L
    List<FuzzySet<T>> labels;  //with used G and K
    ClassicSet<T> denseUniverse;
    List<String> connectives = new ArrayList<>();
    public LinguisticVariable(String name, List<FuzzySet<T>> labels, ClassicSet denseUniverse) {
        this.name = name;
        this.labels = labels;
        this.denseUniverse = denseUniverse;
    }

    public FuzzySet<T> getLabel() {
        return labels.get(0);
    }

    public LinguisticVariable(FuzzySet<T> set) {
        this.name = set.getLabel();
        this.labels = List.of(set);
        this.denseUniverse = set.getUniverse();
    }

    public FuzzySet getByName(String name) {
        int id = 0;
        for (FuzzySet l : labels)
            if (Objects.equals(l.getLabel(), name))
                id = labels.indexOf(l);
        return labels.get(id);
    }

    public LinguisticVariable(List<FuzzySet<T>> labels) {
        this.labels = labels;
    }
    public LinguisticVariable(List<FuzzySet<T>> labels, List<String> connectives) {
        this.connectives = connectives;
        this.labels = labels;
    }
    public FuzzySet compound() {
        List<FuzzySet> fuzzySet = new ArrayList<>();
        fuzzySet.addAll(labels);
        int k =0;
//        for (int i = 1; i < fuzzySet.size(); i += 2) {
//            FuzzySet f = (connectives.get(k).equals("and")) ?
//                    labels.get(i-1).and(labels.get(i)) :
//                    labels.get(i-1).or(labels.get(i));
//            k++;
//            fuzzySet.add(i+1, f);
//        }
        FuzzySet<T> fset = fuzzySet.get(fuzzySet.size()-1);
        name = labels.get(0).getLabel();
        for (int i = 1; i<labels.size(); i++)
            this.name += " " + connectives.get(i-1) + " " + labels.get(i).getLabel();
        return fset;
    }
}
