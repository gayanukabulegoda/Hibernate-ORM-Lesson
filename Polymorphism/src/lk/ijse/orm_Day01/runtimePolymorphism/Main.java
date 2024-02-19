package lk.ijse.orm_Day01.runtimePolymorphism;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.run();
        animal.run(20);
    }
}
