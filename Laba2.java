import java.util.HashSet;
import java.util.Random;

public class laba2 {

    public static void main(String[] args) {
        final int arraySize = 10; // размер последовательности
        final int maxValue = 100; // максимальное значение каждого случайного числа

        Random random = new Random(); // объект random для генерации случайных чисел
        HashSet<Integer> set = new HashSet<>(); // для хранения случайных чисел

        while (set.size() < arraySize) { //размер множества должен быть меньше заданного размера
            set.add(random.nextInt(maxValue) + 1); // генерация случайного числа от 1 до maxValue (включительно) и добавление его в set
        }
        searchMax(set);
    }
    // метод для поиска максимального произведения среди чисел, которые кратны заданным значениям
    public static void searchMax(HashSet<Integer> set) {
        int max14 = -1; // для хранения максимального числа, кратного 14
        int max2 = -1;  // для хранения максимального числа, кратного 2
        int max7 = -1;  // для хранения максимального числа, кратного 7

        for (Integer num : set) {
            if (num % 14 == 0 && num > max14) {
                max14 = num;
            } else if (num % 2 == 0 && num > max2) {
                max2 = num;
            } else if (num % 7 == 0 && num > max7) {
                max7 = num;
            }
        }
        int maxResult = Math.max(max14, (max2 != -1 && max7 != -1) ? max2 * max7 : -1);
        if (maxResult == -1) {
            System.out.println("Не найдено подходящих чисел.");
        } else {
            System.out.println("Максимальное произведение: " + maxResult);
        }
    }
}
