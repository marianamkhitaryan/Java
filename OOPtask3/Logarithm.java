public class Logarithm extends CompositeFunction{
    protected double base;

    public Logarithm(double constant, double base, Function g) {
        super(constant, g);
        this.base = base;
    }

    public Logarithm(Logarithm that) {
        super(that.getConstant(), that.getInnerFunction());
        this.base = that.base;
    }

    public double value(double input) {
        double g = getInnerFunction().value(input);
        return getConstant() * Math.log(g);
    }

    public Function derivative() {
        Function f1 = new Constant(getConstant() / Math.log(base));
        Function f2 = new ComplexFunction(ComplexFunction.Type.QUOTIENT, getInnerFunction().derivative(), getInnerFunction());
        return new ComplexFunction(ComplexFunction.Type.PRODUCT, f1, f2);
    }

    public String toString() {
        return getConstant() + "*log[" + base + "](" + getInnerFunction() + ")";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Logarithm)) {
            return false;
        }
        Logarithm that = (Logarithm) obj;
        return getConstant() == that.getConstant() && base == that.base && getInnerFunction().equals(that.getInnerFunction());
    }

}
