package lk.ijse.orm_Day01.isA_Relationship;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        System.out.println(
                animal.getColor() + "\n" +
                animal.getSpeed() + "\n" +
                animal.getNoOfLegs()
        );
    }
}
