import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Laba9 {

    public static void main(String[] args) {
        String filePath = "\"F:\\123.svc.txt\"";
        String outputFilePath = "statistics.txt";
        
        //проверка расширения файла
        if (!filePath.endsWith(".txt") && !filePath.endsWith(".svc")) {
            System.err.println("Неподдерживаемый формат файла. Можно использовать только файлы с расширением .txt или .svc.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             FileWriter writer = new FileWriter(outputFilePath)) {

            StringBuilder text = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append(" ");
            }

            int totalCharacters = text.toString().length();
            int charactersWithoutSpaces = text.toString().replaceAll("\\s+", "").length();
            int wordCount = text.toString().split("\\s+").length;

            System.out.println("Статистика текста:");
            System.out.println("Общее количество символов: " + totalCharacters);
            System.out.println("Количество символов без пробелов: " + charactersWithoutSpaces);
            System.out.println("Количество слов: " + wordCount);

            writer.write("Статистика текста:\n");
            writer.write("Общее количество символов: " + totalCharacters + "\n");
            writer.write("Количество символов без пробелов: " + charactersWithoutSpaces + "\n");
            writer.write("Количество слов: " + wordCount + "\n");

            System.out.println("Статистика записана в файл " + outputFilePath);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении или записи файла: " + e.getMessage());
        }
    }
}
