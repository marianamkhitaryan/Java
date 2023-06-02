public abstract class SimpleFunction extends Function{

    public abstract Function add(SimpleFunction that);
    public abstract Function multiply(SimpleFunction that);
    public abstract Function subtract(SimpleFunction that);

    public Function add(Function that) {
        return that;
    }

    public Function multiply(Function that) {
        return that;
    }

    public Function subtract(Function that) {
        return that;
    }
}
