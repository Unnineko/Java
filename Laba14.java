import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Laba14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
            System.out.print("Введите строку: ");
            String ip = input.nextLine();
        String regex = "(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)){3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        if (matcher.find()) {
            System.out.println("Найденный IP-адрес: " + matcher.group());
        } else {
            System.out.println("IP-адрес не найден в строке.");
        }
    }
}