import java.util.Random;

public class Laba14 {
    public static final int MAX_ELEMENTS = 10000; //максимальное количество элементов
    public static final int MAX_NUMBER = 100; //максимальное значение элемента

    public static void main(String[] args) {
        int[] numbers = generateRandomSequence(MAX_ELEMENTS, MAX_NUMBER);
        int maxSumOfSquares = findMaxSumOfSquares(numbers);
        System.out.println("Максимальная сумма квадратов двух элементов: " + maxSumOfSquares);
    }

    //генерация случайной последовательности целых чисел
    public static int[] generateRandomSequence(int n, int maxNumber) {
        Random random = new Random();
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = random.nextInt(maxNumber + 1); //генерация случайного числа от 0 до maxNumber
        }
        return sequence;
    }

    //поиск максимальной суммы квадратов двух элементов, различающихся не менее чем на 10
    public static int findMaxSumOfSquares(int[] numbers) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 10; j < numbers.length; j++) {
                int sum = numbers[i] * numbers[i] + numbers[j] * numbers[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
