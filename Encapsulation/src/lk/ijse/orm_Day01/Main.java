package lk.ijse.orm_Day01;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(
                animal.getColor() + "\n" +
                animal.getSpeed() + "\n" +
                animal.getNoOfLegs()
        );
    }
}
