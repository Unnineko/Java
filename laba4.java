import java.util.Scanner;

public class laba4 {
    public static void combSort(int[][] values){
        double factor = 1.247;
        int step = values.length - 1;
        while (step >= 1){
            for (int i = 0; i < values.length; i++){
                for (int j = 0; j + step < values[i].length; ++j){
                    if (values[i][j] > values[i][j + step]) {
                        swap(values,i,j,i,j + step);
                    }
                }
            }
            step /= factor;
        }
    }
    public static void swap(int[][] arr, int i1, int j1, int i2, int j2) {
        int temp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = temp;
    }
    public static void main(String[] args) {
        Scanner in = new  Scanner (System.in);
        System.out.print("Введите количество строк в массиве: ");
        int rows = in.nextInt();
        System.out.print("Введите количество столбцов в массиве: ");
        int columns = in.nextInt();
        int[][] array = new int[rows][columns];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("array[" + i + "][" + j + "]: ");
                array[i][j] = in.nextInt();
            }
        }
        combSort(array);
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}