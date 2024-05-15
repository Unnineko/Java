import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Laba16 {
    public static void main(String[] args) {
        try (
            BufferedReader reader = new BufferedReader(new FileReader("inputFile.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("outputFile.txt"))
        ) {
            String line;
            StringBuilder code = new StringBuilder();
            String regex = "(/\\*([\\S\\s]+?)\\*/)|(//.*)";
            Pattern pattern = Pattern.compile(regex);

            while ((line = reader.readLine()) != null) {
                code.append(line).append("\n");
            }
            line = code.toString();
            Matcher matcher = pattern.matcher(line);
            line = matcher.replaceAll("");

            writer.write(line);
            System.out.println("Комментарии удалены. Код успешно сохранен в outputFile.txt");
        } catch (Exception e) {
            System.out.println("Произошла ошибка при удалении комментариев: " + e.getMessage());
        }
    }
}
