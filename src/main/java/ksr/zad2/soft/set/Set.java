package ksr.zad2.soft.set;

import java.util.ArrayList;

public abstract class Set<T> extends ArrayList<T> {

    private SetType SetType;

    private double begin;
    private double end;

    public Set() {
        super();
    }
}
