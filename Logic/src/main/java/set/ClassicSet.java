package set;

import functions.ConstantFunction;
import functions.MembershipFunction;
import set.Set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClassicSet<T> extends Set {

    public ClassicSet() {
        for (Tag t : tag) {
           t.setMembershipFunctions(new ConstantFunction(universeOfDiscourse));
        }
    }

    public Set sum(Set set) {
        return null;
    }

    public Set odd(Set set) {
        return null;
    }

    public Set multiply(Set set) {
        return null;
    }
    public Set complement(Set set) {
        return null;
    }

    @Override
    public Set and(Set... set) {
        return null;
    }

    @Override
    public Set or(Set... set) {
        return null;
    }

    @Override
    public Set not() {
        return null;
    }
}
