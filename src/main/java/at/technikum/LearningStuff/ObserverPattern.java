package at.technikum.LearningStuff;

import java.util.ArrayList;

enum ObserverType {
    CUSTOMER,
    FINANZAMT
}

interface ObserverInterface {
    void update(String s);

    ObserverType getType();
}

abstract class Observer implements ObserverInterface {
    ObserverType type;

    public Observer(ObserverType type) {
        this.type = type;
    }

    @Override
    abstract public void update(String s);

    @Override
    public ObserverType getType() {
        return this.type;
    }
}

class CustomerObserver extends Observer {
    public CustomerObserver() {
        super(ObserverType.CUSTOMER);
    }

    @Override
    public void update(String s) {
        System.out.println("Message for customer: " + s);
    }
}

class FinanzAmtObserver extends Observer {
    public FinanzAmtObserver() {
        super(ObserverType.FINANZAMT);
    }

    @Override
    public void update(String s) {
        System.out.println("Message for Finanzamt: " + s);
    }
}

interface SubjectInterface {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyCustomer();

    void notifyFinanzamt();
}


class Subject implements SubjectInterface {
    private ArrayList<Observer> observers = new ArrayList<>();

    private String name;
    private int taxClass = 1;

    public Subject(String name) {
        this.name = name;
    }

    public void changeName(String name) {
        this.name = name;
        this.notifyCustomer();
    }

    public void changeTaxClass(int t) {
        this.taxClass = t;
        this.notifyFinanzamt();
    }


    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyCustomer() {
        for (Observer o : observers) {
            if (o.type == ObserverType.CUSTOMER) {
                o.update(this.name);
            }
        }
    }

    @Override
    public void notifyFinanzamt() {
        for (Observer o : observers) {
            if (o.type == ObserverType.FINANZAMT) {
                o.update(String.valueOf(this.taxClass));
            }
        }
    }

}


public class ObserverPattern {
    Subject s1 = new Subject("Product 1");
    Observer o1 = new FinanzAmtObserver();
    Observer o2 = new CustomerObserver();

    public void run() {
        s1.addObserver(o1);
        s1.addObserver(o2);
        s1.changeName("New Name");
        s1.changeTaxClass(2);
    }
}
