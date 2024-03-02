public class Laba8 {
    public static class Person {
        private String Name;
        private String SurName;
        private int birthYear;

        public Person(String Name, String SurName, int birthYear) {
            this.Name = Name;
            this.SurName = SurName;
            this.birthYear = birthYear;
        }

        public void printInfo() {
            System.out.println("Пользователь: " + Name + " " + SurName + ", Год рождения: " + birthYear);
        }
    }

    public static class Car {
        private String brand;
        private int year;
        private double engineVolume;

        public Car(String brand, int year, double engineVolume) {
            this.brand = brand;
            this.year = year;
            this.engineVolume = engineVolume;
        }

        public void printInfo() {
            System.out.println("Машина: " + brand + ", Год выпуска: " + year + ", Объём двигателя: " + engineVolume);
        }
    }

    public static class Book {
        private String title;
        private String author;
        private int year;

        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public void printInfo() {
            System.out.println("Книга: " + title + " от " + author + ", Год публикации: " + year);
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Виктория", "Толмачёва", 1990);
        Car car = new Car("Toyota", 2020, 2.0);
        Book book = new Book("Судьба", "Gen Urobuchi", 2021);

        person.printInfo();
        car.printInfo();
        book.printInfo();

        readBookAboutCar(person, book, car);
    }

    public static void readBookAboutCar(Person person, Book book, Car car) {
        System.out.println(person.Name + " читает книгу " + book.title + " про машину " + car.brand);
    }
}
