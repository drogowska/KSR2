package set;

import functions.*;
import fuzzy.Label;
import lombok.Getter;

import java.util.*;
@Getter
public class FuzzySet extends Set<Double> {

    protected boolean isNormal;
    protected boolean isConvex;
    private boolean isEmpty;
    UniverseOfDiscourse universeOfDiscourse;

    public FuzzySet(UniverseOfDiscourse universeOfDiscourse, List<Label> labels) {
        super();
        this.universeOfDiscourse = universeOfDiscourse;
//        valXY = new  HashMap<>();
//        tags.forEach(t-> valXY.putAll(t.getMembershipFunctions().getValues()));
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
//        isConvex = (isConvex());
    }


    public FuzzySet(UniverseOfDiscourse universe, MembershipFunction function) {
        this.universeOfDiscourse = universeOfDiscourse;
        this.x = universe.x;
        x.forEach(xs -> y.add(function.calculate(xs)));
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
    }

    public UniverseOfDiscourse getUniverseOfDiscourse() {
        return universeOfDiscourse;
    }

    //to do
    private boolean isConvex() {
        return false;
    }

    private boolean isEmpty() {
        int res = 0;
//        for(Map.Entry<Double, Double> entry : valXY.entrySet())
//            if (entry.getValue() == 0) res++;
        for (Double v : y)
            if (v > 0) res++;
        return (res == x.size());
    }

    public FuzzySet(UniverseOfDiscourse universeOfDiscourse, HashMap<Double, Double> valXY) {
        this.universeOfDiscourse = universeOfDiscourse;
//        this.valXY = valXY;
        isEmpty = isEmpty();
        isNormal = (getHeight() == 1.0);
    }

    public ClassicSet getAlphaCut(double alpha) {
        List<Double> tagsList = new ArrayList<>();
//        for(Map.Entry<Double, Double> entry : valXY.entrySet()) {
//            if (entry.getValue() >= alpha)
//                tagsList.add(entry.getKey());
//        }
        for (int i = 0; i < y.size(); i++ ){
            if (y.get(i) >= alpha)
                tagsList.add(x.get(i));
        }
        return new ClassicSet(universeOfDiscourse, tagsList);
    }

    public ClassicSet getSupp() {
        return getAlphaCut(0);
    }

    public Double getHeight() {
        return Collections.max(y);
    }

    @Override
    public Set<Double> sum(Set<Double> set) {
        HashMap<Double, Double> val = new HashMap<>();
        for (int i =0; i < x.size(); i++) {
//            double x = universeOfDiscourse.values.get(i);
//            double y1 = values.get(i).getMembershipFunctions().calculate(x);
//            double y2 = values.get(i).getMembershipFunctions().calculate(x);
//            val.put(x, Math.min(y1, y2));
        }
        return new FuzzySet(universeOfDiscourse, val);
    }
    @Override
    public Set<Double> multiply(Set<Double> set) {
        HashMap<Double, Double> val = new HashMap<>();
//        for (int i =0; i < values.size(); i++) {
//            double x = universeOfDiscourse.values.get(i);
//            double y1 = values.get(i).getMembershipFunctions().calculate(x);
//            double y2 = values.get(i).getMembershipFunctions().calculate(x);
//            val.put(x, Math.max(y1, y2));
//        }
        return new FuzzySet(universeOfDiscourse, val);
    }

    @Override
    public Set<Double> complement() {
        List<Label> labels = new ArrayList<>();
//        values.forEach(v -> {
//            tags.add(new Tag(v.getLabel(), new MembershipFunction(v.getMembershipFunctions().getUniverseOfDiscourse()) {
//                @Override
//                public Double calculate(double x) {
//                    return 1 - v.getMembershipFunctions().calculate(x);
//                }
//            }));
//        });
        return new FuzzySet(universeOfDiscourse, labels);
    }

    public double compatibilityLevel(double x) {
        int id = this.x.indexOf(x);
        return y.get(id);
    }
    public double sigmaCount() {
        double res = 0;
     //   for(Map.Entry<Double, Double> entry : valXY.entrySet()) {
        for (Double i : y)
            res += i;
       // }
        return res;
    }
    @Override
    public FuzzySet and(Set<Double> set) {
        //min
        return (FuzzySet) multiply(set);
    }

    @Override
    public FuzzySet or(Set<Double> set) {
        return null;
    }

    //degree of fuzziness
    public Double in() {
        return Double.valueOf(getSupp().x.size() / universeOfDiscourse.x.size());
    }

}
