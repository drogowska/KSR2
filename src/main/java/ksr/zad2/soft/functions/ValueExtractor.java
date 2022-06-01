package ksr.zad2.soft.functions;
import java.util.function.Function;

@FunctionalInterface
public interface ValueExtractor<T> extends Function<T, Double> {
}
