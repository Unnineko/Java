import java.io.*;
import java.util.Scanner;

class Equation implements Serializable {
    private double x;
    private double y;

    Equation(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double calculateY(double x) {
        return x - Math.sin(x);
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

public class laba17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите x: ");
        double x = scanner.nextDouble();
        Equation equation = new Equation(x, 0);
        scanner.nextLine();

        while (true) {
            System.out.print("Введите команду (save/upload): ");
            String input = scanner.nextLine();

            if (input.equals("save")) {
                try (ObjectOutputStream outputstream = new ObjectOutputStream(new FileOutputStream("saveObject.txt"))) {
                    equation.setY(equation.calculateY(x));
                    outputstream.writeObject(equation);
                    System.out.println("Объект сохранён");

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            } else if (input.equals("upload")) {
                try (ObjectInputStream inputstream = new ObjectInputStream(new FileInputStream("saveObject.txt"))) {
                    Equation newEquation = (Equation) inputstream.readObject();
                    System.out.println("Объект восстановлен");
                    System.out.printf("x: %f \ny: %f \n", newEquation.getX(), newEquation.getY());

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            } else {
                System.out.println("Неверная команда");
                break;
            }
        }
    }
}
