import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class Laba13 {
    public static void main(String[] args){    
        startDownloadThread("https://storage4.lightaudio.ru/dm/39922595/21c1325d/Блич%20—%20Блич%2013%20опенинг%20%28фулл%29%20%28оригинал%29.mp3?play");
        startDownloadThread("https://avatars.mds.yandex.net/i?id=e2aec659db72f3fb298cc7f71677b48f5c9e0b6a-10555711-images-thumbs&n=13");
    }

    public static void downloadFile(String URL){
        try {
            URLConnection connection = new URL(URL).openConnection();
            InputStream inputStream = connection.getInputStream();

            byte[] header = new byte[3];
            inputStream.read(header);                       

            String extension = determineExtension(header);

            if (extension == null) {
                System.out.println("Failed to determine file type.");
                return;
            }

            String fullPath = "downloaded_file" + extension;

            OutputStream outputStream = new FileOutputStream(fullPath);

            outputStream.write(header);
            int data;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }

            System.out.println("File downloaded: " + fullPath);

            Desktop.getDesktop().open(new File(fullPath));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String determineExtension(byte[] header) {
        Map<String, String> extensionsMap = new HashMap<>();
        extensionsMap.put("89 50 4E", ".png");
        extensionsMap.put("49 44 33", ".mp3");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(String.format("%02X ", header[i]));
        }

        String str = sb.toString().trim();

        return extensionsMap.getOrDefault(str, null);
    }

    public static void startDownloadThread(String URL){
        new Thread(() -> downloadFile(URL)).start();
    }
}
