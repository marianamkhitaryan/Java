public class Cotan extends Tan{

    public Cotan(double constant, Function g) {
        super(constant, g);
    }

    public Cotan(Cotan that) {
        super(that);
    }

    public double value(double input) {
        double g = getInnerFunction().value(input);
        return getConstant() / Math.tan(g);
    }

    public Function derivative() {
        Function f1 = new Constant(getConstant());
        Function f2_2 = new ComplexFunction(ComplexFunction.Type.PRODUCT, new Sine(1, getInnerFunction()), new Sine(1, getInnerFunction()));
        Function f2 = new ComplexFunction(ComplexFunction.Type.QUOTIENT, getInnerFunction().derivative(), f2_2);
        return new ComplexFunction(ComplexFunction.Type.PRODUCT, f1, f2);
    }

    public String toString() {
        return String.format("%.2f*cot(%s)", 1 / getConstant(), getInnerFunction());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Cotan)) {
            return false;
        }
        Cotan that = (Cotan) obj;
        return this.getConstant() == that.getConstant() && this.getInnerFunction().equals(that.getInnerFunction());
    }
}
