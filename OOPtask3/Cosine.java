public class Cosine extends TrigonometricFunction{

    public Cosine(double constant, Function g) {
        super(constant, g);
    }

    public Cosine(Cosine that) {
        super(that.getConstant(), that.getInnerFunction());
    }

    public double value(double input) {
        double g = getInnerFunction().value(input);
        return getConstant() * Math.cos(g);
    }

    public Function derivative() {
        Function negatedSin = new Sine((-1) * getConstant(), getInnerFunction());
        return new ComplexFunction(ComplexFunction.Type.PRODUCT, getInnerFunction().derivative(), negatedSin);
    }

    public String toString() {
        return String.format("%.2f*cos(%s)", getConstant(), getInnerFunction());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Cosine)) {
            return false;
        }
        Cosine that = (Cosine) obj;
        return this.getConstant() == that.getConstant() && this.getInnerFunction().equals(that.getInnerFunction());
    }
}
