import java.util.Random;

class AnimalThread extends Thread {
    private String name;
    private int priority;
    private int distance = 0;
    private static final int MAX_DISTANCE = 100;

    public AnimalThread(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.setName(name);
        this.setPriority(priority);
    }

    public void run() {
        Random random = new Random();
        while (distance < MAX_DISTANCE) {
            //увеличение дистанции на какое-то случайное число
            int move = random.nextInt(10) + 1; //движение будет от 1 до 10 метров 
            distance += move;
            System.out.println(name + " пробежал(а) " + distance + " метров.");

            //динамическое изменение приоритета
            if (distance > 50 && this.priority < Thread.MAX_PRIORITY) {
                this.priority++;
                this.setPriority(priority);
                System.out.println(name + " увеличил(а) приоритет до " + priority);
            }

            //задержка до последующего выполнения движения
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " достиг(ла) финиша!");
    }
}

public class RabbitAndTurtle {
    public static void main(String[] args) {
        AnimalThread rabbit = new AnimalThread("Кролик", Thread.NORM_PRIORITY + 1);
        AnimalThread turtle = new AnimalThread("Черепаха", Thread.NORM_PRIORITY);
        
        rabbit.start();
        turtle.start();
        
        try {
            rabbit.join();
            turtle.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //проверка на то, живы ли потоки
        if (rabbit.isAlive()) {
            System.out.println("Кролик выиграл!");
        } else if (turtle.isAlive()) {
            System.out.println("Черепаха выиграла!");
        }
    }
}
