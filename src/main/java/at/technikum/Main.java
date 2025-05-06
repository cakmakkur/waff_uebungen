package at.technikum;

import at.technikum.CarInspectionExample.*;
import at.technikum.LearningStuff.*;
import at.technikum.TagSeparator.TagSeparator;
import at.technikum.week5.HundredDoors;

import javax.swing.text.html.HTML;
import java.net.CookieManager;
import java.util.UUID;

interface Readable {
    // in interface you can also have a field variable
    // but it has to be initialized, and must be (public static final) means cant be changed, not instance-specific
    public static final String interfaceVariable = "DEFAULT VALUE";

    void read();
}

abstract class PrintedStuff {
    private String id;

    public PrintedStuff(String id) {
        this.id = id;
    }

    // this abstract class has its independent read() methode...
    public void read() {
        System.out.println("Default reading");
    }

    // in abstract class you can also only define a methode to be implemented in child class later
    // like in interface
    // but you have to use 'abstract' keyword in methode head:
    public abstract void implementThisLater();

}


class Book extends PrintedStuff implements Readable {
    private String name;


    //wenn kein constructor gegeben, wird default constructor abgerufen.
    // default constructor calls default super() if needed, initializes field variables boolean = false, int = 0 ...


    // constructor without parameter
    public Book() {
        super(UUID.randomUUID().toString());
        this.name = "Default";
        System.out.println(name + " book created");
    }

    // constructor with parameter
    public Book(String name) {
        super(UUID.randomUUID().toString());
        this.name = name;
        System.out.println("Book with the name " + name + " created");
    }

    // beliebig viele constructor möglich, dürfen aber nicht gleice parameter in der gleichen reienfolge haben
    // ein anderer constructor mit (String title) würde nicht gehen weil (String name) existiert

    @Override
    public void read() {
        System.out.println("Book is read");
    }

    public void parentsRead() {
        // calls the read methode from the parent class
        super.read();
    }


    // implementing the abstract definition from the parent

    @Override
    public void implementThisLater() {
        System.out.println("Implemented successfully");
    }
}


public class Main {
    public static void main(String[] args) {
        // b1 gets created with no-parameter constructor
        Book b1 = new Book();

        // b2 get created with parameter constructor
        Book b2 = new Book("Java for dummies");

    }
}