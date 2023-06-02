public class Test {

    public static void main(String[] args) {

//        Polynomial p1 = new Polynomial(new double[]{4, 6, 7, 3});
//        Polynomial p2 = new Polynomial(new double[]{2, 1, 2});
//        Polynomial p3 = new Polynomial(new double[]{1, 1});
//
//        Constant c1 = new Constant(2);
//
//        System.out.printf("%-10s %s\n", "p1: ", p1);
//        System.out.printf("%-10s %s\n", "p2: ", p2);
//        System.out.printf("%-10s %s\n", "p3: ", p3);
//        System.out.printf("%-10s %s\n", "p1(2): ", p1.value(2));
//        System.out.printf("%-10s %s\n", "p2(3): ", p2.value(3));
//
//        System.out.println();
//
//
//        System.out.printf("%-10s %s\n", "p1*c1: ", p1.multiply(c1));
//        System.out.printf("%-10s %s\n", "c1*p2: ", c1.multiply(p2));
//        System.out.printf("%-10s %s\n", "c1+p1: ", c1.add(p1));
//        System.out.printf("%-10s %s\n", "c1-p2: ", c1.subtract(p2));
//
//        System.out.println();
//
//        System.out.printf("%-10s %s\n", "p1*p2: ", p1.multiply(p2));
//        System.out.printf("%-10s %s\n", "(p1*p2)': ", p1.multiply(p2).derivative());
//        System.out.printf("%-10s %s\n", "p1+p2: ", p1.add(p2));
//        System.out.printf("%-10s %s\n", "p2-p1: ", p2.subtract(p1));
//        System.out.printf("%-10s %s\n", "p3^2: ", p3.square());
//
//        System.out.println();

//        Sine s1 = new Sine(new Polynomial(new double[]{1, 0}), 1);
//        System.out.printf("%-10s %s\n", "sin(x): ", s1);
//        System.out.printf("%-10s %s\n", "sin(0): ", s1.value(0));
//        System.out.printf("%-10s %s\n", "sin'(x): ", s1.derivative());
//        System.out.printf("%-10s %s\n", "sin''(x): ", s1.derivative().derivative());
//
//        System.out.println();
//
//        Cosine cos1 = new Cosine(new Polynomial(new double[]{3, 1}), 2);
//        System.out.printf("%-10s %s\n", "cos(x): ", cos1);
//        System.out.printf("%-10s %s\n", "cos(x=1/3): ", cos1.value(-1.0 / 3));
//        System.out.printf("%-10s %s\n", "cos'(x): ", cos1.derivative());
//        System.out.printf("%-10s %s\n", "cos''(x): ", cos1.derivative().derivative());
//
//        System.out.println();
//
//
//        Tan tan = new Tan(new Polynomial(new double[]{1, 0}), 1);
//
//        System.out.printf("%-10s %s\n", "tan(x): ", tan);
//        System.out.printf("%-10s %s\n", "tan(PI/2): ", tan.value(Math.PI / 2));
//        System.out.printf("%-10s %s\n", "tan(0): ", tan.value(0));
//        System.out.printf("%-10s %s\n", "tan'(x): ", tan.derivative());
//
//        System.out.println();
//
//        Cotan cotan = new Cotan(new Polynomial(new double[]{1, 0}), 3);
//
//        System.out.printf("%-10s %s\n", "cot(x): ", cotan);
//        System.out.printf("%-10s %s\n", "cot(PI/2): ", cotan.value(Math.PI / 2));
//        System.out.printf("%-10s %s\n", "cot(0): ", cotan.value(0));
//        System.out.printf("%-10s %s\n", "cot'(x): ", cotan.derivative());
//
//        System.out.println();
//
//
//        Logarithm log = new Logarithm(new Logarithm(2, new Polynomial(new double[]{1, 0}), 3));
//
//        System.out.printf("%-10s %s\n", "log(x): ", log);
//        System.out.printf("%-10s %s\n", "log(128): ", log.value(128));
//        System.out.printf("%-10s %s\n", "log(1): ", log.value(1));
//        System.out.printf("%-10s %s\n", "log'(x): ", log.derivative());
//
//        System.out.println();
//
//        Logarithm ln = new Ln(new Polynomial(new double[]{1, 0}), 2);
//
//        System.out.printf("%-10s %s\n", "ln(x): ", ln);
//        System.out.printf("%-10s %s\n", "ln(E): ", ln.value(Math.E));
//        System.out.printf("%-10s %s\n", "ln(1): ", ln.value(1));
//        System.out.printf("%-10s %s\n", "ln'(x): ", ln.derivative());
//
//        System.out.println();

//        Exponential exp1 =
//                new Exponential(1, 3, new Polynomial(new double[]{1, 2, 1}));
//
//
//        System.out.printf("%-10s %s\n", "exp1(x): ", exp1);
//        System.out.printf("%-10s %s\n", "exp1(2): ", exp1.value(2));
//        System.out.printf("%-10s %s\n", "exp1(0): ", exp1.value(0));
//        System.out.printf("%-10s %s\n", "exp1'(x): ", exp1.derivative());
//
//        System.out.println();
//
//        Exponential exp2 =
//                new Exponential(1, Math.E, new Polynomial(new double[]{1, 0}));
//
//        System.out.printf("%-10s %s\n", "exp2(x): ", exp2);
//        System.out.printf("%-10s %s\n", "exp2(2): ", exp2.value(2));
//        System.out.printf("%-10s %s\n", "exp2(0): ", exp2.value(0));
//        System.out.printf("%-10s %s\n", "exp2'(x): ", exp2.derivative());
//
//        System.out.println();
//
//
//        ComplexFunction complexFunction1 =
//                new ComplexFunction(ComplexFunction.Type.QUOTIENT, p1, s1);
//        ComplexFunction complexFunction2 =
//                new ComplexFunction(ComplexFunction.Type.PRODUCT, log, tan);
//        ComplexFunction complexFunction3 =
//                new ComplexFunction(ComplexFunction.Type.SUM, cos1, exp1);
//        ComplexFunction complexFunction4 =
//                new ComplexFunction(ComplexFunction.Type.DIFFERENCE, cotan, complexFunction2);

//        System.out.println();
//
//        System.out.printf("%-10s %s\n", "complexFunction1(x): ", complexFunction1);
//        System.out.printf("%-10s %s\n", "complexFunction1(0): ", complexFunction1.value(0));
//        System.out.printf("%-10s %s\n", "complexFunction1(1): ", complexFunction1.value(1));
//        System.out.printf("%-10s %s\n", "complexFunction1'(x): ", complexFunction1.derivative());
//
//        System.out.println();
//
//        System.out.printf("%-10s %s\n", "complexFunction2(x): ", complexFunction2);
//        System.out.printf("%-10s %s\n", "complexFunction2(0): ", complexFunction2.value(0));
//        System.out.printf("%-10s %s\n", "complexFunction2(1): ", complexFunction2.value(1));
//        System.out.printf("%-10s %s\n", "complexFunction2'(x): ", complexFunction2.derivative());
//
//        System.out.println();
//
//        System.out.printf("%-10s %s\n", "complexFunction3(x): ", complexFunction3);
//        System.out.printf("%-10s %s\n", "complexFunction3(0): ", complexFunction3.value(0));
//        System.out.printf("%-10s %s\n", "complexFunction3(1): ", complexFunction3.value(1));
//        System.out.printf("%-10s %s\n", "complexFunction3'(x): ", complexFunction3.derivative());
//
//        System.out.println();
//
//        System.out.printf("%-10s %s\n", "complexFunction4(x): ", complexFunction4);
//        System.out.printf("%-10s %s\n", "complexFunction4(0): ", complexFunction4.value(0));
//        System.out.printf("%-10s %s\n", "complexFunction4(1): ", complexFunction4.value(1));
//        System.out.printf("%-10s %s\n", "complexFunction4'(x): ", complexFunction4.derivative());
//
//        System.out.println();
//
//        ComplexFunction last = new ComplexFunction(ComplexFunction.Type.SUM,
//                new ComplexFunction(ComplexFunction.Type.PRODUCT, new Sine(new Logarithm(2, new Polynomial(new double[]{2, 5}), 4), 2),
//                        new Exponential(2, 3, new Polynomial(new double[]{1, 0}))), p1);
//
//        System.out.printf("%-10s %s\n", "last(x): ", last);
//        System.out.printf("%-10s %s\n", "last(0): ", last.value(0));
//        System.out.printf("%-10s %s\n", "last(1): ", last.value(1));
//        System.out.printf("%-10s %s\n", "last'(x): ", last.derivative());
    }
}