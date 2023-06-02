public abstract class TrigonometricFunction extends CompositeFunction {
    public TrigonometricFunction(double constant, Function innerFunction) {
        super(constant, innerFunction);
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof TrigonometricFunction)) return false;
        TrigonometricFunction tf = (TrigonometricFunction) obj;
        return this.getConstant() == tf.getConstant() && this.getInnerFunction().equals(tf.getInnerFunction());
    }

}
