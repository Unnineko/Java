import java.util.Scanner;

public class laba4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите два числа (number1 и number2):");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();

        System.out.println("Выберите метод умножения:\n" +
                   "1 - Использовать мат. свойство умножения\n" +
                   "2 - Выполнить сложение\n" +
                   "3 - Использовать побитовые операции\n" +
                   "4 - Умножение через логарифмы\n" +
                   "5 - Применить деление\n" +
                   "6 - Рекурсивное умножение");

        int method = scanner.nextInt();
        int result;

        switch (method) {
            case 1:
                //обычное умножение по математическому свойству
                result = calculateUsingMathProperty(number1, number2);
                break;
            case 2:
                //умножение через сложение
                result = multiplyByAddition(number1, number2);
                break;
            case 3:
                //умножение через побитовые операции
                result = multiplyByBitwise(number1, number2);
                break;
            case 4:
                //умножение с использованием логарифмов
                result = multiplyUsingLogarithms(number1, number2);
                break;
            case 5:
                //умножение с использованием деления
                result = multiplyUsingDivision(number1, number2);
                break;
            case 6:
                //умножение рекурсией
                result = recursiveMultiplication(number1, number2);
                break;
            default:
                System.out.println("Некорректный выбор способа умножения!");
                return;
        }

        System.out.println("Результат: " + result);
    }

    private static int calculateUsingMathProperty(int number1, int number2) {
        return (int) ((Math.pow(number1 + number2, 2) - Math.pow(number1, 2) - Math.pow(number2, 2)) / 2);
    } //математическое свойство умножения для вычисления произведения: a * b = (a + b)^2 - a^2 - b^2) / 2

    private static int multiplyByAddition(int number1, int number2) {
        int total = 0;
         //цикл для сложения number1, number2
        for (int i = 0; i < Math.abs(number2); i++) {
            total += number1;
        }
        return (number2 < 0) ? -total : total;
    } //если number2 отрицательное,знак total меняется на противоположный

    private static int multiplyByBitwise(int number1, int number2) {
        int absA = Math.abs(number1);
        int absB = Math.abs(number2);
        int product = 0;

        while (absB > 0) {
            //проверка самого правого бита absB; если он равен 1, absA добавляется к product
            if ((absB & 1) == 1) {
                product += absA;
            }
            //умножение absA на 2 (сдвиг влево)
            absA <<= 1;
            //деление absB на 2 (сдвиг вправо)
            absB >>= 1;
        }

        if ((number1 < 0) ^ (number2 < 0)) {
            product = -product;
        }
        return product;
    }

    private static int multiplyUsingLogarithms(int number1, int number2) {
        if (number1 == 0 || number2 == 0) return 0;
        //вычисление натуральных логарифмов по значениям number1 и number2
        double logA = Math.log(Math.abs(number1));
        double logB = Math.log(Math.abs(number2));
        int result = (int) Math.pow(Math.E, logA + logB);

        return (number1 < 0) ^ (number2 < 0) ? -result : result;
    }

    private static int multiplyUsingDivision(int number1, int number2) {
        //проверка не равно ли number2 нулю, предотвращая деление на 0
        if (number2 == 0) return 0;
        return (int) ((int) (double) number1 / (1 / (double) number2));
    }

    private static int recursiveMultiplication(int number1, int number2) {
        //если number2 равно 0, возвращается 0, т.к любое число умноженное на 0 равно 0
        if (number2 == 0) return 0;
        //если number2 положительное, рекурсивно складывается number1 с результатом умножения
        if (number2 > 0) return number1 + recursiveMultiplication(number1, number2 - 1);
        //если number2 отрицательное, меняется знак и рекурсивно вызывается функцию с положительным значением
        return -recursiveMultiplication(number1, -number2);
    }
}
