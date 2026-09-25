package guru.qa;

public class FirstClass {

    public static void main(String... args) {

        // 0) применить несколько арифметических операций ( + , -, * , /) над двумя примитивами типа int
        int aInt = 5;
        int bInt = 7;
        int arithmeticResult = (aInt + bInt) * bInt - aInt / bInt;
        System.out.println("0) (aInt + bInt) * bInt - aInt / bInt = " + arithmeticResult);

        // 1) применить несколько арифметических операций над int и double в одном выражении
        double cDouble = 2.5;
        double mixedResult = aInt + bInt * cDouble - aInt / cDouble;
        System.out.println("1) aInt + bInt * cDouble - aInt / cDouble = " + mixedResult);

        // 2) применить несколько логических операций ( < , >, >=, <= )
        boolean lessThan = aInt < bInt;
        boolean greaterThan = aInt > bInt;
        boolean greaterOrEqual = aInt >= bInt;
        boolean lessOrEqual = aInt <= bInt;
        System.out.println("2) aInt < bInt = " + lessThan);
        System.out.println("2) aInt > bInt = " + greaterThan);
        System.out.println("2) aInt >= bInt = " + greaterOrEqual);
        System.out.println("2) aInt <= bInt = " + lessOrEqual);

        // 3) прочитать про диапазоны типов данных для вещественных / чисел с плавающей точкой (какие максимальные и минимальные значения есть, как их получить) и переполнение
        System.out.println("3) Float.MIN_VALUE  = " + Float.MIN_VALUE);
        System.out.println("3) Float.MAX_VALUE  = " + Float.MAX_VALUE);
        System.out.println("3) Double.MIN_VALUE = " + Double.MIN_VALUE);
        System.out.println("3) Double.MAX_VALUE = " + Double.MAX_VALUE);

        // 4) получить переполнение при арифметической операции
        int overflowedInt = Integer.MAX_VALUE + 1;
        System.out.println("4) Integer.MAX_VALUE + 1 = " + overflowedInt);

        double overflowedDouble = Double.MAX_VALUE * 2;
        System.out.println("4) Double.MAX_VALUE * 2 = " + overflowedDouble);
    }
}
