class Animal {
    String food;
    String location;

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public void makeNoise() {
        System.out.println("Животное шумит");
    }

    public void eat() {
        System.out.println("Животное ест");
    }

    public void sleep() {
        System.out.println("Животное спит");
    }
}

class Dog extends Animal {
    int FullYears;

    public Dog(String food, String location, int FullYears) {
        super(food, location);
        this.FullYears = FullYears;
    }

    @Override
    public void makeNoise() {
        System.out.println("Собака лает");
    }

    @Override
    public void eat() {
        System.out.println("Собака ест собачий корм");
    }
}

class Cat extends Animal {
    int NumberOfKittens;

    public Cat(String food, String location, int NumberOfKittens) {
        super(food, location);
        this.NumberOfKittens = NumberOfKittens;
    }

    @Override
    public void makeNoise() {
        System.out.println("Кошка мяукает");
    }

    @Override
    public void eat() {
        System.out.println("Кошка доедает селёдку");
    }
}

class Horse extends Animal {
    String breed;

    public Horse(String food, String location, String breed) {
        super(food, location);
        this.breed = breed;
    }

    @Override
    public void makeNoise() {
        System.out.println("Лошадь фыркает");
    }

    @Override
    public void eat() {
        System.out.println("Лошадь ест ячмень");
    }
}

class Veterinarian {
    public void treatAnimal(Animal animal) {
        System.out.println("Еда: " + animal.food);
        System.out.println("Местоположение: " + animal.location);
    }
}

public class Laba10 {
    public static void main(String[] args) {
        Dog dog = new Dog("Собачий корм", "Частный дом", 7);
        Cat cat = new Cat("Селёдка", "Квартира", 5);
        Horse horse = new Horse("Ячмень", "Ферма", "Андалузская");

        Veterinarian veterinarian = new Veterinarian();
        veterinarian.treatAnimal(dog);
        veterinarian.treatAnimal(cat);
        veterinarian.treatAnimal(horse);
    }
}
