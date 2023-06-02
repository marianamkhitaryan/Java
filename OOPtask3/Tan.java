public class Tan extends TrigonometricFunction{

    public Tan(double constant, Function g) {
        super(constant, g);
    }

    public Tan(Tan that) {
        super(that.getConstant(), that.getInnerFunction());
    }

    public double value(double input) {
        double g = getInnerFunction().value(input);
        return getConstant() * Math.tan(g);
    }

    public Function derivative() {
        Function f1 = new Constant(getConstant());
        Function f2_2 = new ComplexFunction(ComplexFunction.Type.PRODUCT, new Cosine(1, getInnerFunction()), new Cosine(1, getInnerFunction()));
        Function f2 = new ComplexFunction(ComplexFunction.Type.QUOTIENT, getInnerFunction().derivative(), f2_2);
        return new ComplexFunction(ComplexFunction.Type.PRODUCT, f1, f2);
    }

    public String toString() {
        return String.format("%.2f*tan(%s)", getConstant(), getInnerFunction());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tan)) {
            return false;
        }
        Tan that = (Tan) obj;
        return this.getConstant() == that.getConstant() && this.getInnerFunction().equals(that.getInnerFunction());
    }

}
