package set;

public class FuzzySet extends Set {

    private FuzzySetType type;

    public ClassicSet getAlphaCut(double alpha) {
        return null;
    }

    public ClassicSet getSupp() {
        return null;
    }

    public Double getHeight() {
        return null;
    }

    public Set sum(Set set) {
        return null;
    }
    public Set multiply(Set set) {
        return null;
    }
    public Set getComplement(Set set) {
        return null;
    }

    public FuzzySet and(FuzzySet set) {
        //min
        return null;
    }

    public FuzzySet or(FuzzySet set) {
        //max
        return null;
    }

    public FuzzySet not() {
        return null;//1 - getComplement(this);
    }
}
