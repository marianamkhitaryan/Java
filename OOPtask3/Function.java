abstract class Function {

    public abstract double value(double input);
    public abstract Function derivative();
    public abstract void scale(double scalar);

     public Function divide(Function that) {
         return new ComplexFunction(ComplexFunction.Type.QUOTIENT, this, that);
     }

     public Function subtract(Function that) {
         return new ComplexFunction(ComplexFunction.Type.DIFFERENCE, this, that);
     }
     public Function add(Function that) {
         return new ComplexFunction(ComplexFunction.Type.SUM, this, that);
     }
     public Function multiply(Function that) {
         return new ComplexFunction(ComplexFunction.Type.PRODUCT, this, that);
     }
     public Function square() {
         return new ComplexFunction(ComplexFunction.Type.PRODUCT, this, this);
     }
     public static Function copy(Function that) {
         if (that instanceof ComplexFunction) {
             ComplexFunction complexFunction = (ComplexFunction) that;
             return new ComplexFunction(complexFunction.type, complexFunction.f.copy(that), complexFunction.g.copy(that));
         }else if (that instanceof Exponential) {
             Exponential exponential = (Exponential) that;
             return new Exponential(exponential.getConstant(), exponential.base, exponential.getInnerFunction());
         }else if (that instanceof Logarithm) {
             Logarithm logarithm = (Logarithm) that;
             return new Logarithm(logarithm.getConstant(), logarithm.base, logarithm.getInnerFunction());
         }else if (that instanceof Ln) {
             Ln ln = (Ln) that;
             return new Ln(ln.getConstant(), ln.getInnerFunction());
         }else if (that instanceof Sine) {
             Sine sine = (Sine) that;
             return new Sine(sine.getConstant(), sine.getInnerFunction());
         }else if (that instanceof Cosine) {
             Cosine cosine = (Cosine) that;
             return new Cosine(cosine.getConstant(), cosine.getInnerFunction());
         }else if (that instanceof Tan) {
             Tan tan = (Tan) that;
             return new Tan(tan.getConstant(), tan.getInnerFunction());
         }else if (that instanceof Cotan) {
             Cotan cotan = (Cotan) that;
             return new Cotan(cotan.getConstant(), cotan.getInnerFunction());
         }
         return null;
     }
}
