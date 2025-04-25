package at.technikum.LearningStuff;

interface State {
    void act();
}

class HappyState implements State {

    @Override
    public void act() {
        System.out.println("I am smiling :)");
    }
}

class AngryState implements State {

    @Override
    public void act() {
        System.out.println("What's your problem you f.king bastard!!!!");
    }
}

class Person {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void act() {
        state.act();
    }
}


public class StatePattern {

    public void run() {
        Person person1 = new Person();
        suckerpunchThePerson(person1);
        person1.act();
        complimentThePerson(person1);
        person1.act();
    }

    public void suckerpunchThePerson(Person person) {
        person.setState(new AngryState());
    }

    public void complimentThePerson(Person person) {
        person.setState(new HappyState());
    }
}
