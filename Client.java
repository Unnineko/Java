import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Адрес сервера
        int port = 12345; // Порт сервера

        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.print("Введите текст для шифрования: ");
            String text = userInput.readLine(); // Ввод текста от пользователя
            System.out.print("Введите сдвиг: ");
            int shift = Integer.parseInt(userInput.readLine()); // Ввод сдвига от пользователя

            out.println(text); // Отправка текста на сервер
            out.println(shift); // Отправка сдвига на сервер

            String encryptedText = in.readLine(); // Получение зашифрованного текста от сервера
            System.out.println("Зашифрованный текст: " + encryptedText);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
