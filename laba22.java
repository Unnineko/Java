import java.util.ArrayList;
import java.util.List;


interface Observer {
    void update(String message);
}

class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Пользователь " + name + " получил оповещение: " + message);
    }
}

class Group {
    private List<Observer> observers = new ArrayList<>();
    private String groupName;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("Новое оповещение в группе " + groupName);
        }
    }
}

public class laba22 {
    public static void main(String[] args) {
        User user1 = new User("Пользователь 1");
        User user2 = new User("Пользователь 2");

        Group group1 = new Group("Группа 1");
        Group group2 = new Group("Группа 2");
        Group group3 = new Group("Группа 3");
        Group group4 = new Group("Группа 4");

        group1.addObserver(user1);
        group2.addObserver(user1);
        group3.addObserver(user1);

        group1.addObserver(user2);
        group2.addObserver(user2);
        group3.addObserver(user2);
        group4.addObserver(user2);

        group1.notifyObservers();
        group2.notifyObservers();
        group3.notifyObservers();
        group4.notifyObservers();
    }
}