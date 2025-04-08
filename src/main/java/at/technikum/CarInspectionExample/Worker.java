package at.technikum.CarInspectionExample;

abstract public class Worker {
    private final String name;
    private final int hourlyRate;

    public Worker(String n, int hr) {
        this.name = n;
        this.hourlyRate = hr;
    }

    public String getName() {
        return name;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }
}
