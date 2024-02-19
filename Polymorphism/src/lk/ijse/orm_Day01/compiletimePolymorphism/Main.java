package lk.ijse.orm_Day01.compiletimePolymorphism;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.run();
        animal.run(20);
    }
}
