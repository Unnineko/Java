import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 12345; // Порт сервера
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Клиент подключен: " + clientSocket.getInetAddress());
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String text = in.readLine(); // Чтение текста от клиента
            int shift = Integer.parseInt(in.readLine()); // Чтение сдвига от клиента
            String encryptedText = encrypt(text, shift); // Шифрование текста
            out.println(encryptedText); // Отправка зашифрованного текста обратно клиенту

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        shift = shift % 32; //убедиться что сдвиг не превышает 32 для русского алфавита

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                if (c >= 'а' && c <= 'я') { // Русский алфавит
                    char base = 'а';
                    c = (char) ((c - base + shift + 32) % 32 + base);
                } else if (c >= 'А' && c <= 'Я') { // Русский заглавный алфавит
                    char base = 'А';
                    c = (char) ((c - base + shift + 32) % 32 + base);
                } else if (c >= 'a' && c <= 'z') { // Английский алфавит
                    char base = 'a';
                    c = (char) ((c - base + shift + 26) % 26 + base);
                } else if (c >= 'A' && c <= 'Z') { // Английский заглавный алфавит
                    char base = 'A';
                    c = (char) ((c - base + shift + 26) % 26 + base);
                }
            }
            encrypted.append(c);
        }
        return encrypted.toString();
    }
}
