package at.technikum;

import at.technikum.CarInspectionExample.*;
import at.technikum.TagSeparator.TagSeparator;

import javax.swing.text.html.HTML;


public class Main {
    public static void main(String[] args) {
        Workshop w = new Workshop();
        w.addWorker(new SeniorWorker("Tom"));
        w.addWorker(new JuniorWorker("Tina"));
        w.addWorker(new JuniorWorker("Tami"));

        w.setJob(new CarInspection(new Audi(1999)));

        w.printReport();
    }
}