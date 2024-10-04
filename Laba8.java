import java.util.Random;

public class Laba8 {
    public static void main(String[] args) {
        Random random = new Random();
        boolean chickenLast = random.nextBoolean(); 

        Thread chickenThread = new Thread(() -> {
            if (chickenLast) {
                System.out.println("Курица");
            } else {
                System.out.println("Курица говорит последней!");
            }
        });

        Thread eggThread = new Thread(() -> {
            if (!chickenLast) {
                System.out.println("Яйцо");
            } else {
                System.out.println("Яйцо говорит последним!");
            }
        });

        chickenThread.start();
        eggThread.start();

        while (chickenThread.isAlive() || eggThread.isAlive()) {
        }

        try {
            chickenThread.join();
            eggThread.join();
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
