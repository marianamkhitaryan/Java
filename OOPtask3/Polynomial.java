import java.sql.SQLOutput;

// !!!! the methods add, multiply and toString are partially from chatGPT

public class Polynomial extends SimpleFunction {

    private int degree;
    private double[] coefficients;
    private Constant lastTerm;

    public Polynomial (double[] coefficients) {
        this.coefficients = new double[coefficients.length];
        this.degree = coefficients.length - 1;
        this.lastTerm = new Constant(coefficients[0]);
    }

    public Polynomial (Polynomial that) {
        for (int i = 0; i < coefficients.length; i++) {
            this.coefficients[i] = that.coefficients[i];
        }
        this.degree = that.degree;
        this.lastTerm = new Constant(that.lastTerm);
    }

    public double value(double input) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(input, degree - i);
        }
        return result;
    }

    public Function derivative() {
        double[] derivativeCoefficients = new double[degree];
        for (int i = 0; i < degree; i++) {
            derivativeCoefficients[i] = (degree) * coefficients[i];
        }
        lastTerm = new Constant(coefficients[1]);
        return new Polynomial(derivativeCoefficients);
    }

    public void scale(double scalar) {
        for (int i = 0; i <= degree; i++) {
            coefficients[i] *= scalar;
        }
    }

    public Function add(SimpleFunction that) {
        if (that instanceof Constant) {
            double newConstant = lastTerm.value(0) + that.value(0);
            return new Polynomial(new double[]{newConstant});
        } else if (that instanceof Polynomial) {
            int newDegree = Math.max(this.degree, ((Polynomial) that).degree);
            double[] newCoefficients = new double[newDegree + 1];
            for (int i = 0; i <= newDegree; i++) {
                double thisCoefficient = (i <= this.degree) ? this.coefficients[i] : 0;
                double thatCoefficient = (i <= ((Polynomial) that).degree) ? ((Polynomial) that).coefficients[i] : 0;
                newCoefficients[newDegree - i] = thisCoefficient + thatCoefficient;
            }
            return new Polynomial(newCoefficients);
        }
        return new Polynomial((double[]) null);
    }

    public Function subtract(SimpleFunction that) {
        SimpleFunction negatedThat = (SimpleFunction) that.multiply(new Constant(-1));
        return this.add(negatedThat);
    }

    public Function multiply(SimpleFunction that) {
        if (that instanceof Constant) {
            double newConstant = lastTerm.value(0) * that.value(0);
            return new Polynomial(new double[]{newConstant});
        } else if (that instanceof Polynomial) {
            int newDegree = this.degree + ((Polynomial) that).degree;
            double[] newCoefficients = new double[newDegree + 1];
            for (int i = 0; i <= this.degree; i++) {
                for (int j = 0; j <= ((Polynomial) that).degree; j++) {
                    int power = this.degree - i + ((Polynomial) that).degree - j;
                    double coefficient = this.coefficients[i] * ((Polynomial) that).coefficients[j];
                    newCoefficients[newDegree - power] += coefficient;
                }
            }
            return new Polynomial(newCoefficients);
        }
        return new Polynomial((double[]) null);
    }

    public Function square() {
        return this.multiply(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = degree; i >= 0; i--) {
            double coefficient = coefficients[i];
            if (coefficient == 0) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append(" + ");
            }
            sb.append(coefficient);
            if (i > 0) {
                sb.append("x");
                if (i > 1) {
                    sb.append("^").append(i);
                }
            }
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        return (this == obj);
    }

}
