interface User {
    void setPassword(String password);
    String getPassword();
    void setLogin(String login);
    String getLogin();
}

abstract class People implements User {
    protected String fullName;
    protected int age;
    protected String position;
    protected String login;
    protected String password;

    public People(String fullName, int age, String position) {
        this.fullName = fullName;
        this.age = age;
        this.position = position;
    }

    @Override
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getLogin() {
        return this.login;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}

class Teacher extends People {
    public Teacher(String fullName, int age, String position) {
        super(fullName, age, position);
    }
}

class Student extends People {
    public Student(String fullName, int age, String position) {
        super(fullName, age, position);
    }
}

public class Laba12 {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Пауков Полина Павловна", 40, "Педагог");
        teacher1.setLogin("paukova_paulina");
        teacher1.setPassword("p4uk0v4");

        Student student1 = new Student("Петров Петр Петрович", 20, "Студент");
        student1.setLogin("petrov_petr");
        student1.setPassword("p3tr0v");
    }
}
