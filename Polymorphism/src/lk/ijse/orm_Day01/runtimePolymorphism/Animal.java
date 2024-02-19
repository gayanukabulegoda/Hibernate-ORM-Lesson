package lk.ijse.orm_Day01.runtimePolymorphism;

public class Animal {
    private double speed;
    private String color;
    private int noOfLegs;

    public Animal() {
    }

    public Animal(double speed, String color, int noOfLegs) {
        this.speed = speed;
        this.color = color;
        this.noOfLegs = noOfLegs;
    }

    public void run() {
        System.out.println("Animal is Running");
    }

    public void run(int speed) {
        System.out.println("Speed: " + speed + " kmPh-1");
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

    public int getNoOfLegs() {
        return noOfLegs;
    }

    public void setNoOfLegs(int noOfLegs) {
        this.noOfLegs = noOfLegs;
    }

    @Override
    public String toString() {
        return "lk.ijse.lk.ijse.orm_Day01.Animal{" +
                "speed=" + speed +
                ", color='" + color + '\'' +
                ", noOfLegs=" + noOfLegs +
                '}';
    }
}
