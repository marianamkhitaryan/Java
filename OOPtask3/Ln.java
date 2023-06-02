public class Ln extends Logarithm{

    private static final double e = Math.E;

    public Ln(double constant, Function g) {
        super(constant, e, g);
    }

    public Ln(Ln that) {
        super(that);
    }

    public String toString() {
        return String.format("%.2f*ln(%s)", super.value(0), getInnerFunction().toString());
    }


    public boolean equals(Object that) {
        if (that == this) {
            return true;
        }
        if (!(that instanceof Ln)) {
            return false;
        }
        Ln ln = (Ln) that;
        return this.equals(ln.getInnerFunction());
    }
}
