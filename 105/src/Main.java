import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\17.txt");
        Scanner scanner = new Scanner(file);

        //считываем данные из файла
        List<Integer> numbers = new ArrayList<>();
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }

        //минимальное трехзначное число, делящееся на 7
        int minThreeDigit = 105;

        //определение минимального четырехзначного числа
        int minFourDigit = Integer.MAX_VALUE;
        for (int num : numbers) {
            if (1000 <= num && num < 10000) {
                minFourDigit = Math.min(minFourDigit, num);
            }
        }

        //если не найдено четырехзначное число, выводим 0
        if (minFourDigit == Integer.MAX_VALUE) {
            System.out.println(0 + " " + 0);
            return;
        }

        //последняя цифра минимального четырехзначного числа
        int lastDigit = minFourDigit % 10;

        int countPairs = 0;
        int maxSum = Integer.MIN_VALUE;

        //обработка пар
        for (int i = 0; i < numbers.size() - 1; i++) {
            int a = numbers.get(i);
            int b = numbers.get(i + 1);

            //условие на наличие элемента меньше 105
            if (a < minThreeDigit || b < minThreeDigit) {
                //условие на произведение
                if ((a * b) % 10 == lastDigit) {
                    countPairs++;
                    maxSum = Math.max(maxSum, a + b);
                }
            }
        }

        //если не найдено ни одной удовлетворяющей пары
        if (countPairs == 0) {
            maxSum = 0;
        }

        //количество пар и максимальную из сумм
        System.out.println(countPairs + " " + maxSum);
    }
}