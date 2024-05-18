import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Laba15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String ip = input.nextLine();
        String regex = "(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)){3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        
        BufferedWriter writer = null;
        
        if (matcher.find()) {
            System.out.println("Найденный IP-адрес: " + matcher.group());
            try {
                writer = new BufferedWriter(new FileWriter("ip_addresses.txt", true));
                writer.write(matcher.group() + "\n");
                System.out.println("IP-адрес успешно записан в файл.");
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии файла: " + e.getMessage());
                }
            }
        } else {
            System.out.println("IP-адрес не найден в строке.");
        }
    }
}
