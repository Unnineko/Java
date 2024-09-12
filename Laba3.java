import java.util.*;

public class laba3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MAX_SMS_COUNT = 1000; // максимально допустимое количество сообщений
        final int TOTAL_PAIRS = 16; // общее количество пар

        // запрос у пользователя о количестве SMS-сообщений для голосования
        int totalVotes = 0;
        System.out.println("Введите количество до 1000 сообщений включительно");
        while (true) {
            totalVotes = scanner.nextInt(); // получение введенного количества сообщений
            if (totalVotes <= MAX_SMS_COUNT) break; // проверка что общее количество голосов не превышает максимальное 
            else System.out.println("Ошибка ввода! Требуется ввести число, которое не будет превышать 1000:");
        }

        // HashMap для хранения голосов
        HashMap<Integer, Integer> voteCounts = new HashMap<>();

        // инициализация голоса 0 для всех пар
        for (int i = 1; i <= TOTAL_PAIRS; i++) {
            voteCounts.put(i, 0);
        }

        System.out.println("За какие номера пар Вы хотите проголосовать?");
        for (int i = 0; i < totalVotes; i++) {
            int selectedPair = scanner.nextInt();
            if (selectedPair >= 1 && selectedPair <= TOTAL_PAIRS) {
                voteCounts.put(selectedPair, voteCounts.get(selectedPair) + 1);
            } else {
                System.out.println("Ошибка! Номер пары должен быть в диапазоне от 1 до 16.");
            }
        }

        // список для хранения пар и их голосов для последующей сортировки
        List<Map.Entry<Integer, Integer>> sortedPairs = new ArrayList<>(voteCounts.entrySet());

        // список пар по количеству голосов в порядке убывания
        sortedPairs.sort((entryA, entryB) -> entryB.getValue().compareTo(entryA.getValue()));

        System.out.println("Итоги голосования:");
        for (Map.Entry<Integer, Integer> pair : sortedPairs) {
            System.out.println("Пара " + pair.getKey() + ": " + pair.getValue() + " голосов");
        }
    }
}
