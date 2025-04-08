package at.technikum.CarInspectionExample;

public class CarInspection implements Job {
    private static final int INSP_TIME = 10;
    private static final int MIN_WORKER = 2;
    private static int BASE_PRICE;

    private final Car c;

    public CarInspection(Car c) {
        this.c = c;
        BASE_PRICE = c.getYear() < 2000 ? 200 : 150;
    }

    @Override
    public int getMinNumberOfWorkers() {
        return MIN_WORKER;
    }

    @Override
    public int getBasePrice() {
        return BASE_PRICE;
    }

    @Override
    public int getHours() {
        return INSP_TIME;
    }
}
