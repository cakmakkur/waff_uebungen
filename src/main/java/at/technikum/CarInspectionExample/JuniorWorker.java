package at.technikum.CarInspectionExample;

public class JuniorWorker extends Worker {
    private static final int hourlyRate = 20;

    public JuniorWorker(String name) {
        super(name, hourlyRate);
    }
}
