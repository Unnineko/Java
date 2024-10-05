import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Laba10 {

    //метод для последовательного копирования файлов
    private static void copyFilesSequentially(String sourceFile1, String sourceFile2, String destFile1, String destFile2) {
        try {
            //замерка времени начала операции копирования
            long start = System.nanoTime();

            //копирование первого файла с помощью метода Files.copy()
            Files.copy(Paths.get(sourceFile1), Paths.get(destFile1));

            //замерка времени окончания копирования первого файла
            long end = System.nanoTime();
            System.out.println("Время копирования файла 1: " + (end - start) / 1_000_000 + " мс");

            //замерка времени начала копирования второго файла
            start = System.nanoTime();

            //копирование второго файла с помощью метода Files.copy()
            Files.copy(Paths.get(sourceFile2), Paths.get(destFile2));

            //замерка времени окончания копирования второго файла
            end = System.nanoTime();
            System.out.println("Время копирования файла 2: " + (end - start) / 1_000_000 + " мс");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //метод для параллельного копирования файлов
    private static void copyFilesInParallel(String sourceFile1, String sourceFile2, String destFile1, String destFile2) {
        ExecutorService executor = Executors.newFixedThreadPool(2); //пул потоков с фиксированным количеством потоков, равным 2. 
        try {
            //замерка времени начала операции копирования
            long start = System.nanoTime();

            executor.submit(() -> {
                try {
                    //копирование первого файла с помощью метода Files.copy()
                    Files.copy(Paths.get(sourceFile1), Paths.get(destFile1));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            executor.submit(() -> {
                try {
                    //копирование второго файла с помощью метода Files.copy()
                    Files.copy(Paths.get(sourceFile2), Paths.get(destFile2));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            //останов приема новых задач
            executor.shutdown();

            //ожидание завершения задач
            while (!executor.isTerminated()) {
            }

            //замерка времени окончания операции копирования
            long end = System.nanoTime();
            System.out.println("Общее время параллельного копирования: " + (end - start) / 1_000_000 + " мс");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //пути к исходным и целевым файлам
        String sourceFile1 = "F:\\123.txt";
        String sourceFile2 = "F:\\4321.txt";
        String destFile1 = "F:\\путь_для_первого_файла.txt";
        String destFile2 = "F:\\путь_для_второго_файла.txt";

        System.out.println("Последовательное копирование:");
        //метод для последовательного копирования файлов
        copyFilesSequentially(sourceFile1, sourceFile2, destFile1, destFile2);

        System.out.println("\nПараллельное копирование:");
        //метод для параллельного копирования файлов
        copyFilesInParallel(sourceFile1, sourceFile2, destFile1, destFile2);
    }
}
