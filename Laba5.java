import java.util.Scanner;

public class Laba5 {
    Scanner scanner = new Scanner(System.in);
    
    public double calculate1(int x) {
        return 3*x + 5;
    }
    
    public double calculate2(int a, int b) {
        return (a + b) / (a - b);
    }
    
    public double calculate3(int a, int b, int x) {
        return Math.pow(a*x/b, 2);
    }
    
    public static void main(String[] args) {
        Laba5 calculator = new Laba5();
        
        System.out.print("Введите значение x для выражения y = 3x + 5: ");
        int x1 = calculator.scanner.nextInt();
        double result1 = calculator.calculate1(x1);
        System.out.println("Результат выражения y = 3x + 5: " + result1);
        
        System.out.print("Введите значение a для выражения y = (a + b) / (a - b): ");
        int a = calculator.scanner.nextInt();
        
        System.out.print("Введите значение b: ");
        int b = calculator.scanner.nextInt();
        double result2 = calculator.calculate2(a, b);
        System.out.println("Результат выражения y = (a + b) / (a - b): " + result2);
        
        System.out.print("Введите значение a для выражения y = (ax/b)!: ");
        a = calculator.scanner.nextInt();
        
        System.out.print("Введите значение b: ");
        b = calculator.scanner.nextInt();
        
        System.out.print("Введите значение x: ");
        int x3 = calculator.scanner.nextInt();
        double result3 = calculator.calculate3(a, b, x3);
        System.out.println("Результат выражения y = (ax/b)!: " + result3);
        
        calculator.scanner.close();
    }
}
