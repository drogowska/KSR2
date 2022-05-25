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
        valXY = new  HashMap<>();
        tags.forEach(t-> valXY.putAll(t.getMembershipFunctions().getValues()));
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
//        isConvex = (isConvex());
    }

    private boolean isEmpty() {
        int res = 0;
        for(Map.Entry<Double, Double> entry : valXY.entrySet())
            if (entry.getValue() == 0) res++;
        return (res == valXY.size());
    }

    public FuzzySet(UniverseOfDiscourse universeOfDiscourse, HashMap<Double, Double> valXY) {
        this.universeOfDiscourse = universeOfDiscourse;
        this.valXY = valXY;
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
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

    @Override
    public Set sum(Set<Tag> set) {
        HashMap<Double, Double> val = new HashMap<>();
        for (int i =0; i < values.size(); i++) {
            double x = universeOfDiscourse.values.get(i);
            double y1 = values.get(i).getMembershipFunctions().calculate(x);
            double y2 = values.get(i).getMembershipFunctions().calculate(x);
            val.put(x, Math.min(y1, y2));
        }
        return new FuzzySet(universeOfDiscourse, val);
    }
    @Override
    public Set<Tag> multiply(Set<Tag> set) {
        HashMap<Double, Double> val = new HashMap<>();
        for (int i =0; i < values.size(); i++) {
            double x = universeOfDiscourse.values.get(i);
            double y1 = values.get(i).getMembershipFunctions().calculate(x);
            double y2 = values.get(i).getMembershipFunctions().calculate(x);
            val.put(x, Math.max(y1, y2));
        }
        return new FuzzySet(universeOfDiscourse, val);
    }

    @Override
    public Set<Tag> complement() {
        List<Tag> tags = new ArrayList<>();
        values.forEach(v -> {
            tags.add(new Tag(v.getLabel(), new MembershipFunction(v.getMembershipFunctions().getUniverseOfDiscourse()) {
                @Override
                public Double calculate(double x) {
                    return 1 - v.getMembershipFunctions().calculate(x);
                }
            }));
        });
        return new FuzzySet(universeOfDiscourse, tags);
    }

//    public int cardinality() { inczaej sigma count
//        return valXY.size();  //?
//    }
    private double sigmaCount() {
        double res = 0;
        for(Map.Entry<Double, Double> entry : valXY.entrySet()) {
            res += entry.getValue();
        }
        return res;
    }
    @Override
    public FuzzySet and(Set<Tag> set) {
        //min
        return (FuzzySet) multiply(set);
    }

    @Override
    public FuzzySet or(Set<Tag> set) {
        return null;
    }

    //degree of fuzziness
    private Double in() {
        return Double.valueOf(getSupp().values.size() / universeOfDiscourse.values.size());
    }

}
