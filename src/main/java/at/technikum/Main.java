package at.technikum;

import at.technikum.CarInspectionExample.*;
import at.technikum.LearningStuff.*;
import at.technikum.TagSeparator.TagSeparator;
import at.technikum.week5.HundredDoors;

import javax.swing.text.html.HTML;
import java.net.CookieManager;


public class Main {
    public static void main(String[] args) {
/*        Workshop w = new Workshop();
        w.addWorker(new SeniorWorker("Tom"));
        w.addWorker(new JuniorWorker("Tina"));
        w.addWorker(new JuniorWorker("Tami"));

        w.setJob(new CarInspection(new Audi(1999)));
        HundredDoors.run();
        w.printReport();*/

/*        ObserverPattern o = new ObserverPattern();
        o.run();*/
/*
        StrategyPattern sp = new StrategyPattern();
        sp.run();*/

/*        DecoratorPattern dp = new DecoratorPattern();
        dp.run();*/

/*        CommandPattern cp = new CommandPattern();
        cp.run();*/

        StatePattern sp = new StatePattern();
        sp.run();
    }
}