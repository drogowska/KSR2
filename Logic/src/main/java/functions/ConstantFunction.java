package functions;

public class ConstantFunction extends LineFunction {
    public ConstantFunction(UniverseOfDiscourse universe) {
        super(0, -1, universe);
    }

    @Override
    public Double calculate(double x) {
        return 1.0;
    }
}
