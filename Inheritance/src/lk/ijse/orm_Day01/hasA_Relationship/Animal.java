package lk.ijse.orm_Day01.hasA_Relationship;

public class Animal {
    private double speed;
    private String color;
    private Legs noOfLegs;

    public Animal() {
    }

    public Animal(double speed, String color, Legs noOfLegs) {
        this.speed = speed;
        this.color = color;
        this.noOfLegs = noOfLegs;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Legs getNoOfLegs() {
        return noOfLegs;
    }

    public void setNoOfLegs(Legs noOfLegs) {
        this.noOfLegs = noOfLegs;
    }

    @Override
    public String toString() {
        return "lk.ijse.orm_Day01.isA_Relationship.Animal{" +
                "speed=" + speed +
                ", color='" + color + '\'' +
                ", noOfLegs=" + noOfLegs +
                '}';
    }
}
