class Person {
    private int age;
    public String fullName;
    public String phone;

    public Person(int age, String fullName, String phone) {
        this.age = age;
        this.fullName = fullName;
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Student extends Person {
    public String faculty;
    public int course;
    private String admissionDate;

    public Student(int age, String fullName, String phone, String faculty, int course, String admissionDate) {
        super(age, fullName, phone);
        this.faculty = faculty;
        this.course = course;
        this.admissionDate = admissionDate;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }
}

public class Laba11 {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student(20, "Ivan Ivanov", "123456789", "Physics", 2, "2020-09-01");
        students[1] = new Student(22, "Maria Petrova", "987654321", "Mathematics", 3, "2019-08-15");
        students[2] = new Student(21, "Alexandr Sidorov", "567891234", "IT technology", 1, "2021-01-10");
        
        System.out.println("ФИО и возраст всех студентов:");
        for (Student student : students) {
            System.out.println(student.fullName + ", возраст: " + student.getAge());
        }

        String targetFaculty = "Mathematics";
        System.out.println("\nСтуденты факультета " + targetFaculty + ":");
        for (Student student : students) {
            if (student.getFaculty().equals(targetFaculty)) {
                System.out.println(student.fullName);
            }
        }

        String targetYear = "2019";
        System.out.println("\nСтуденты, поступившие после " + targetYear + ":");
        for (Student student : students) {
            if (Integer.parseInt(student.getAdmissionDate().substring(0, 4)) > Integer.parseInt(targetYear)) {
                System.out.println(student.fullName);
            }
        }
    }
}
