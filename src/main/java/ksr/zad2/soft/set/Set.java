package ksr.zad2.soft.set;

import java.util.ArrayList;

public /*abstract*/ class Set<T> extends ArrayList<T> {

    protected float xStart;
    protected float xEnd;
    private SetType SetType;

    public Set() {
        super();
    }

    public Set(float xStart, float xEnd) {
        this.xStart = xStart;
        this.xEnd = xEnd;
    }

    public float getxStart() {
        return xStart;
    }

    public float getxEnd() {
        return xEnd;
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

    public ksr.zad2.soft.set.SetType getSetType() {
        return SetType;
    }

    public void setSetType(ksr.zad2.soft.set.SetType setType) {
        SetType = setType;
    }
}
