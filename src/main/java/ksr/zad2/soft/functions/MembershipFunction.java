package ksr.zad2.soft.functions;

public abstract class MembershipFunction<T> {

    public abstract float calculate(T t);
    public abstract float getSupport();
    public abstract float getCardinality();
    public abstract MembershipFunction denormalized();
}
