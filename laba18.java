import java.util.Scanner;
interface Expression{
    boolean isEqual(int a, int b);
}

public class laba18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите длину массива: ");
        int n = in.nextInt();
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            System.out.printf("Введите %d-ый элемент массива: ", i);
            array[i] = in.nextInt();
        }

        System.out.print("Введите способ сортировки(! - по убыванию; ^ - по возрастанию): ");
        String oper = in.next();

        if(oper.equals("^")){
            Expression func = (a,b) -> a > b;
            bubleSort(array, func);
        } else if (oper.equals("!")) {
            Expression func = (a,b) -> a < b;
            bubleSort(array, func);
        } else System.out.println("Неправильно введён способ сортировки");

        System.out.println("Отсортированный массив:");
        for (int j : array) {
            System.out.print(j + " ");
        }
    }
    public static void bubleSort(int[] sortArr,Expression func){
            for (int i = 0; i < sortArr.length - 1; i++) {
                for (int j = 0; j < sortArr.length - i - 1; j++) {
                    if (func.isEqual(sortArr[j],sortArr[j + 1])) {
                        int temp = sortArr[j];
                        sortArr[j] = sortArr[j + 1];
                        sortArr[j + 1] = temp;
                    }
                }
            }
        }
    }