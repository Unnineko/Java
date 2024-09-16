import java.io.IOException;

public class Laba5 {
    public static void main(String[] args) {
        Process[] processes = new Process[3]; //массив для хранения процессов

        try {
            //создаю 3 процесса блокнота
            for (int i = 0; i < 3; i++) {
                processes[i] = new ProcessBuilder("notepad.exe").start(); //сам запуск блокнота
                System.out.println("Запущен процесс блокнота: " + (i + 1));

                //ожидание 2 секунды
                Thread.sleep(2000);
            }

            //удаление процессов
            for (int i = 0; i < 3; i++) {
                processes[i].destroy(); // Завершение процесса
                System.out.println("Завершен процесс блокнота: " + (i + 1));
            }

        } catch (IOException e) {
            System.err.println("Ошибка при запуске процесса: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("Ошибка при ожидании: " + e.getMessage());
        }
    }
}
