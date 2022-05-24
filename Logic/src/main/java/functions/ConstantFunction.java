package functions;

public class ConstantFunction extends LineFunction{
    public ConstantFunction(double b) {
        super(0, b);
    }

    @Override
    public Double calculate(double x) {
        return this.b*x;
    }
}
