package set;

import functions.*;
import lombok.Getter;

import java.util.*;
@Getter
public class FuzzySet extends Set<Tag> {

    protected boolean isNormal;
    protected boolean isConvex;
    private boolean isEmpty;
    UniverseOfDiscourse universeOfDiscourse;
    HashMap<Double, Double> valXY;
    public FuzzySet(UniverseOfDiscourse universeOfDiscourse, List<Tag> tags) {
        super();
        this.universeOfDiscourse = universeOfDiscourse;
        if (tags.isEmpty()) isEmpty = true;
        else if (getHeight() == 1.0) isNormal = true;

        valXY = new  HashMap<>();
        tags.forEach(t-> valXY.putAll(t.getMembershipFunctions().getValues()));
    }

    public ClassicSet getAlphaCut(double alpha) {
        List<Double> tagsList = new ArrayList<>();
        for(Map.Entry<Double, Double> entry : valXY.entrySet()) {
            if (entry.getValue() >= alpha)
                tagsList.add(entry.getKey());  //przestrzeń rozważań jednopunktowa, o wartości funkcji przynależności 1
        }

        return new ClassicSet(universeOfDiscourse, tagsList);
    }

    public ClassicSet getSupp() {
        return getAlphaCut(0);
    }

    public Double getHeight() {
        return Collections.max(valXY.values());
    }

//x jest l1 i l2 => min {uS1(x), uS2(x)}
    public Set sum() {

        return null;
    }

    @Override
    public Set sum(Set set) {
        return null;
    }

    public Set multiply(Set set) {
        return null;
    }
    public Set complement(Set set) {
        return null;
    }

    public int cardinality() {
        return valXY.size();  //?
    }
    private double sigmaCount() {
        double res = 0;
        for(Map.Entry<Double, Double> entry : valXY.entrySet()) {
            res += entry.getValue();
        }
        return res;
    }
    @Override
    public FuzzySet and(Set... set) {
        //min
        return null;
    }

    @Override
    public FuzzySet or(Set... set) {
        //max
        return null;
    }

}
