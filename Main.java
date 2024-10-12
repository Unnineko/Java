import java.util.Random;

class Account {
    private double balance = 0.0;

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Пополнение счета на: " + amount + ", новый баланс: " + balance);
        notifyAll(); //уведомление ожидающих потоков о том, что баланс пополнен
    }

    public synchronized void withdraw(double amount) throws InterruptedException {
        while (balance < amount) {
            System.out.println("Недостаточно средств для снятия: " + amount + ". Ожидание пополнения...");
            wait(); //ожидание пока баланс не станет достаточным
        }
        balance -= amount;
        System.out.println("Снятие со счета: " + amount + ", новый баланс: " + balance);
    }

    public synchronized double getBalance() {
        return balance;
    }
}

class DepositThread extends Thread {
    private final Account account;

    public DepositThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            double amount = random.nextDouble() * 100; //случайная сумма от 0 до 100
            account.deposit(amount);
            try {
                Thread.sleep(1000); //пауза между пополнениями
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        
        //запуск потоков для пополнения счета
        DepositThread depositThread = new DepositThread(account);
        depositThread.start();

        try {
            //снятие денег, когда накопится нужная сумма
            Thread.sleep(5000); //5 секунд перед первым снятием
            account.withdraw(50); //снять 50
            Thread.sleep(5000); //5 секунд перед следующим снятием
            account.withdraw(80); //снять 80
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        //останов потока пополнения
        depositThread.interrupt();
    }
}
