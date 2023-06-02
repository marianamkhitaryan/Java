public class ComplexFunction extends Function {
    public enum Type {
        SUM, DIFFERENCE, PRODUCT, QUOTIENT
    }

    Type type;
    protected Function f;
    protected Function g;

    public ComplexFunction(Type type, Function f, Function g) {
        this.type = type;
        this.f = f;
        this.g = g;
    }

    public ComplexFunction(ComplexFunction that) {
        this.type = that.type;
        this.f = that.f;
        this.g = that.g;
    }

    public void scale(double scalar) {
        switch (type) {
            case SUM, DIFFERENCE, PRODUCT:
                f.scale(scalar);
                g.scale(scalar);
                break;
            case QUOTIENT:
                f.scale(scalar);
                break;
        }
    }

    public double value(double input) {
        switch (type) {
            case SUM:
                return f.value(input) + g.value(input);
            case DIFFERENCE:
                return f.value(input) - g.value(input);
            case PRODUCT:
                return f.value(input) * g.value(input);
            case QUOTIENT:
                return f.value(input) / g.value(input);
            default:
                return 0;
        }
    }

    public Function derivative() {
        switch (type) {
            case SUM:
                return f.derivative().add(g.derivative());
            case DIFFERENCE:
                return f.derivative().subtract(g.derivative());
            case PRODUCT:
                return (f.multiply(g.derivative())).add(f.derivative().multiply(g));
            case QUOTIENT:
                return ((f.derivative().multiply(g)).subtract(g.derivative().multiply(f))).divide(g.square());
            default:
                return null;
        }
    }

    public String toString() {
        switch (type) {
            case SUM:
                return "(" + f.toString() + ") + (" + g.toString() + ")";
            case DIFFERENCE:
                return "(" + f.toString() + ") - (" + g.toString() + ")";
            case PRODUCT:
                return "(" + f.toString() + ") * (" + g.toString() + ")";
            case QUOTIENT:
                return "(" + f.toString() + ") / (" + g.toString() + ")";
            default: return null;
        }
    }

}
