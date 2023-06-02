
// !!!! the method equals is from chatGPT
public abstract class CompositeFunction extends Function {
    private double constant;
    private Function innerFunction;

    public CompositeFunction(double constant, Function innerFunction) {
        this.constant = constant;
        this.innerFunction = innerFunction.copy(innerFunction);
    }

    public double getConstant() {
        return constant;
    }

    public Function getInnerFunction() {
        return innerFunction;
    }

    public void scale(double scalar) {
        this.constant *= scalar;
        this.innerFunction.scale(scalar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CompositeFunction)) {
            return false;
        }

        CompositeFunction that = (CompositeFunction) obj;
        return Double.compare(this.constant, that.constant) == 0 && this.innerFunction.equals(that.innerFunction);
    }

}