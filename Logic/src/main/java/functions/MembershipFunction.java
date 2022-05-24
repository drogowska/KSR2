package functions;

public abstract class MembershipFunction {
    UniverseOfDiscourse universeOfDiscourse;

    public UniverseOfDiscourse getUniverseOfDiscourse() {
        return universeOfDiscourse;
    }

    public abstract Double calculate(double x);
}
