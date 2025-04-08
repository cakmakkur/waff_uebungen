package at.technikum.CarInspectionExample;

public class SeniorWorker extends Worker {
    private static final int hourlyRate = 50;

    public SeniorWorker(String name) {
        super(name, hourlyRate);
    }
}
