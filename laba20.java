import java.util.Scanner;
enum Calc{
    RES;
    private double x, y;

    public void setValues(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double calculate(){
        return 2*x+3/y;
    }
}

public class laba20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите х: ");
        double x = in.nextDouble();

        System.out.print("Введите y: ");
        double y = in.nextDouble();

        Calc.RES.setValues(x,y);

        System.out.println("Результат: " + Calc.RES.calculate());
    }
}