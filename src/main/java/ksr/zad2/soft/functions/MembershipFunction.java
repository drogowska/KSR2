package ksr.zad2.soft.functions;

public interface MembershipFunction<T> {

    float calculate(T t);
    float getSupport();
}
