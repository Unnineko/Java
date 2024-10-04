import java.util.Random;

public class Laba8 {
    public static void main(String[] args) {
        Random random = new Random();
        boolean chickenLast = random.nextBoolean();

        Thread chickenThread = new Thread(() -> { //создание нового потока для курицы
            if (chickenLast) {
                System.out.println("Курица");
            } else {
                System.out.println("Курица говорит последней!");
            }
        });
        
        Thread eggThread = new Thread(() -> { //создание нового потока для яйца
            if (!chickenLast) {
                System.out.println("Яйцо");
            } else {
                System.out.println("Яйцо говорит последним!");
            }
        });

        chickenThread.start(); //запуск потока курицы
        eggThread.start(); //запуск потока яйца

        while (chickenThread.isAlive() || eggThread.isAlive()) {
            //проверка активны ли потоки курицы и яйца
        }

        try {
            chickenThread.join(); // ожидание завершения работы потока курицы
            eggThread.join(); //ожидание завершения работы потока яйца
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (chickenLast) {
            System.out.println("Спор выигрывает курица!");
        } else {
            System.out.println("Спор выигрывает яйцо!");
        }
    }
}
