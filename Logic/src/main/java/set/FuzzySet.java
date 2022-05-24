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
    public Set complement(Set set) {
        return null;
    }

    public int cardinality() {
        return 0;
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

    public FuzzySet not() {
        return null;//1 - getComplement(this);
    }
}
