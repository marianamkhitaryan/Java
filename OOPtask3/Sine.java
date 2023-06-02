public class Sine extends TrigonometricFunction{

    public Sine(double constant, Function g) {
        super(constant, g);
    }

    public Sine(Sine that) {
        super(that.getConstant(), that.getInnerFunction());
    }

    public double value(double input) {
        double g = getInnerFunction().value(input);
        return getConstant() * Math.sin(g);
    }

    public Function derivative() {
        Function cos = new Cosine(getConstant(), getInnerFunction());
        return new ComplexFunction(ComplexFunction.Type.PRODUCT, getInnerFunction().derivative(), cos);
    }

    public String toString() {
        return String.format("%.2f*sin(%s)", getConstant(), getInnerFunction());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Sine)) {
            return false;
        }
        Sine that = (Sine) obj;
        return this.getConstant() == that.getConstant() && this.getInnerFunction().equals(that.getInnerFunction());
    }
}
