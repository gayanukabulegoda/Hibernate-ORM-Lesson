package lk.ijse.orm_Day01.runtimePolymorphism;

public class Dog extends Animal {
    @Override
    public void run() {
        System.out.println("Dog is Running");
    }

    @Override
    public void run(int speed) {
        System.out.println("Dog's Speed: " + speed + " kmPh-1");
    }
}
