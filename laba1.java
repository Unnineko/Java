import java.util.Scanner;

public class laba1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.println("Введите элементы массива:");

        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        int majorityElement = findMajorityElement(array);

        System.out.println("Мажоритарный элемент: " + majorityElement);

        double majorityPercentage = ((double) countOccurrences(array, majorityElement) / size) * 100;
        System.out.println("Процент мажоритарности: " + majorityPercentage + "%");

        scanner.close();
    }

    private static int findMajorityElement(int[] array) {
        int majorityElement = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                majorityElement = array[i];
                count = 1;
            } else if (array[i] == majorityElement) {
                count++;
            } else {
                count--;
            }
        }

        return majorityElement;
    }

    private static int countOccurrences(int[] array, int element) {
        int count = 0;
        for (int num : array) {
            if (num == element) {
                count++;
            }
        }
        return count;
    }
}
