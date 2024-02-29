import java.util.Scanner;

public class Laba2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите значение x:");
        double x = input.nextDouble();
        System.out.println("Введите количество членов ряда:");
        int n = input.nextInt();
        double sum = 0;

        for (int i=0; i<n; i++) {
            sum += Math.pow(-1, i) * Math.pow(x, 2*i) / factorial(i);
        }
        System.out.println("Сумма ряда: " + sum);
    }

    public static double factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}