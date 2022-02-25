public class Main {

    public static void main(String[] args) {
        Calculator calculator = Calculator.instance.get();

        int a = calculator.plus.apply(1, 2);
        int b = calculator.minus.apply(1, 1);
        boolean z = calculator.isPositive.test(-20);


        calculator.println.accept(a);
        calculator.println.accept(b);
        calculator.printlnForBoolean.accept(z);

        try {
            int c = calculator.devide.apply(a, b);
            calculator.println.accept(c);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Деление на 0!");
        }

    }


}
