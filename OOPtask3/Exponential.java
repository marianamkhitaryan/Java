public class Exponential extends CompositeFunction{
    protected double base;

    public Exponential(double constant, double base, Function g) {
        super(constant, g);
        this.base = base;
    }

    public Exponential(Exponential that) {
        super(that.getConstant(), that.getInnerFunction());
        this.base = that.base;
    }

    public double value(double input) {
        double g = getInnerFunction().value(input);
        return getConstant() * Math.pow(base, g);
    }

    public Function derivative() {
        Function newFunction =  new ComplexFunction(ComplexFunction.Type.PRODUCT, getInnerFunction().derivative(), getInnerFunction());
        double newConst = getConstant() * Math.log(base);
        return new Exponential(newConst, base, newFunction);
    }
}
