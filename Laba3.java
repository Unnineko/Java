import java.util.Arrays;

public class Laba3 {

    public static void main(String[] args) {
        int[][] arr = {
            {5, 2, 9, 1},
            {8, 3, 4, 7},
            {6, 1, 3, 2}
        };
        
        System.out.println("До сортировки: ");
        printArray(arr);
        
        for (int i = 0; i < arr.length; i++) {
            quickSort(arr[i], 0, arr[i].length - 1);
        }        
        
        System.out.println("После сортировки: ");
        printArray(arr);
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}
