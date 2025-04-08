package at.technikum.CarInspectionExample;

abstract public class Car {
    private final int year;

    public Car(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

}
