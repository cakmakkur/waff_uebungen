package at.technikum.LearningStuff;

import java.util.ArrayList;
import java.util.List;

interface StrategyInterface {
    void pay();
}

class Kartenzahlung implements StrategyInterface {
    @Override
    public void pay() {
        System.out.println("Mit Karte gezahlt");
    }
}

class BankUeberweisung implements StrategyInterface {
    @Override
    public void pay() {
        System.out.println("EPS-Zahlung");
    }
}

class Einkaufswagen {
    ArrayList<String> products = new ArrayList<>(List.of("a", "b"));
    StrategyInterface paymentMethod;

    void setPaymentMethod(StrategyInterface method) {
        this.paymentMethod = method;
    }

    void pay() {
        paymentMethod.pay();
    }

}

public class StrategyPattern {
    Einkaufswagen ew = new Einkaufswagen();

    StrategyInterface karte = new Kartenzahlung();
    StrategyInterface transfer = new BankUeberweisung();

    public void run() {
        ew.setPaymentMethod(karte);
        ew.pay();
        ew.setPaymentMethod(transfer);
        ew.pay();
    }
}
