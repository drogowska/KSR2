package ksr.zad2.soft.set;

import java.util.ArrayList;

public /*abstract*/ class Set<T> extends ArrayList<T> {

    private float xStart;
    private float xEnd;

    public Set() {
        super();
    }

    public Set(float xStart, float xEnd) {
        this.xStart = xStart;
        this.xEnd = xEnd;
    }

    public Set<T> sum(Set<T> s) {
        return null;
    }

    public Set<T> multiply(Set<T> s) {
        return null;
    }

    public Set<T> getComplement() {
        return null;
    }
}
