package ksr.zad2.soft.fuzzy;

import com.zaxxer.hikari.util.FastList;
import ksr.zad2.soft.functions.MembershipFunction;
import ksr.zad2.soft.set.ClassicSet;
import ksr.zad2.soft.set.FuzzySet;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

import static ksr.zad2.soft.SoftApplication.database;

@Getter
public class FuzzyQuantifier extends LinguisticVariable<Double> {

    private boolean isAbsolute;
//    private HashMap<Double, Double> map = new HashMap<>();

    public FuzzyQuantifier(String label, MembershipFunction membershipFunctions) {
        super(label, List.of(new FuzzySet(new ClassicSet(0, database.size()), membershipFunctions)),
                new ClassicSet(0, database.size()));
        for (Double d : denseUniverse)
            map.put(d,d);
    }

    public FuzzyQuantifier(String label, MembershipFunction membershipFunctions, boolean isAbsolute) {
        this(label, membershipFunctions);
        this.isAbsolute = isAbsolute;
    }

    public boolean isAbsolute() {
        return isAbsolute;
    }
}
