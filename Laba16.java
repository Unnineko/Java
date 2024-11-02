import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Laba16 {
    public static void main(String[] args) {
        String inputFileName = "F:\\числа.txt"; //имя входного файла
        int[][] numberPairs = fetchPairsFromFile(inputFileName); //считывание пар чисел из файла

        if (numberPairs != null) {
            //максимальная сумма
            long maximumSum = computeMaximumSum(numberPairs);
            System.out.println(maximumSum);
        }
    }

    private static int[][] fetchPairsFromFile(String fileName) {
        int[][] numberPairs = null;

        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            int totalPairs = Integer.parseInt(fileReader.readLine().trim()); //количество пар
            numberPairs = new int[totalPairs][2];

            for (int index = 0; index < totalPairs; index++) {
                String[] splitLine = fileReader.readLine().split(" ");
                numberPairs[index][0] = Integer.parseInt(splitLine[0]);
                numberPairs[index][1] = Integer.parseInt(splitLine[1]);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка формата числа: " + e.getMessage());
        }

        return numberPairs;
    }

    private static long computeMaximumSum(int[][] pairs) {
        long highestSum = 0;

        //начальная сумма по максимальным числам из каждой пары
        for (int[] currentPair : pairs) {
            highestSum += getMax(currentPair);
        }

        //проверка на делимость
        if (isDivisibleByThree(highestSum)) {
            long minimumAdjustment = findMinimumAdjustment(pairs);
            if (minimumAdjustment != Long.MAX_VALUE) {
                return highestSum - minimumAdjustment;
            }
        }

        return highestSum; //если не делится, то возвращаем сумму
    }

    private static long getMax(int[] pair) {
        return Math.max(pair[0], pair[1]);
    }

    private static boolean isDivisibleByThree(long sum) {
        return sum % 3 == 0;
    }

    private static long findMinimumAdjustment(int[][] pairs) {
        long minAdjustment = Long.MAX_VALUE;

        for (int[] currentPair : pairs) {
            long chosenMax = getMax(currentPair);
            long alternativeMin = Math.min(currentPair[0], currentPair[1]);
            long adjustment = chosenMax - alternativeMin;

            if (adjustment % 3 != 0) {
                minAdjustment = Math.min(minAdjustment, adjustment);
            }
        }

        return minAdjustment;
    }
}
