import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Laba12 {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\umine\\Documents\\Java\\24_demo.txt";

        int maxSequenceLength = 0; //максимальная длина последовательности
        int currentSequenceLength = 0; //текущая длина последовательности

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int ch;
            while ((ch = br.read()) != -1) {
                char currentChar = (char) ch;
                if (currentChar == 'X') {
                    currentSequenceLength++; //увеличение текущей длины
                } else {
                    if (currentSequenceLength > maxSequenceLength) {
                        maxSequenceLength = currentSequenceLength; //обновление максимальной длины
                    }
                    currentSequenceLength = 0; //сброс текущей длины, если не 'X'
                }
            }
            //проверка одной последней последовательности в конце файла
            if (currentSequenceLength > maxSequenceLength) {
                maxSequenceLength = currentSequenceLength;
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        //проверка был ли найден хотя бы один символ 'X'
        if (maxSequenceLength > 0) {
            System.out.println("Длина самой длинной последовательности 'X': " + maxSequenceLength);
        } else {
            System.out.println("В файле не найдено символов 'X'.");
        }
    }
}
