
// !!!! the method equals is from chatGPT
public class Constant extends SimpleFunction {

    private double constantValue;

    public Constant (double constantValue) {
        this.constantValue = constantValue;
    }

    public Constant (Constant that) {
        this.constantValue = that.constantValue;
    }

    public double value(double input) {
        return input;
    }

    public double value() {
        return constantValue;
    }

    public Function derivative() {
        return new Constant(0);
    }

    public void scale(double scalar) {
        constantValue *= scalar;
    }

    public Function add(SimpleFunction that) {
        if (that instanceof Constant) {
            return new Constant(constantValue + ((Constant) that).constantValue);
        } else if (that instanceof Polynomial) {
            return that.add(this);
        }
        return new Constant(0);
    }

    public Function subtract(SimpleFunction that) {
        SimpleFunction negatedThat = (SimpleFunction) that.multiply(new Constant(-1));
        return this.add(negatedThat);
    }

    public Function multiply(SimpleFunction that) {
        if (that instanceof Constant) {
            return new Constant(constantValue * ((Constant) that).constantValue);
        } else if (that instanceof Polynomial) {
            return that.multiply(this);
        }
        return new Constant(0);
    }

    public Function square() {
        return this.multiply(this);
    }

    public Function divide(Function that) {
        return new Constant(this.value() / ((Constant) that).value());
    }

    public String toString() {
        return Double.toString(constantValue);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Constant) {
            Constant that = (Constant) obj;
            return this.constantValue == that.constantValue;
        }
        return false;
    }
}
