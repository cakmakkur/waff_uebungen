package at.technikum.LearningStuff;

import java.sql.SQLOutput;

interface Command {
    void execute();
}

interface Switchable {
    void turnOn();

    void turnOff();
}

class Light implements Switchable {

    @Override
    public void turnOn() {
        System.out.println("Light is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is turned off");
    }
}

class Fan implements Switchable {

    @Override
    public void turnOn() {
        System.out.println("Fan is turned on");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is turned off");
    }
}

class LightsOnCommand implements Command {
    private Light light;

    public LightsOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class LightsOffCommand implements Command {
    private Light light;

    public LightsOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class FanOnCommand implements Command {
    private Fan fan;

    public FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOn();
    }
}

class FanOffCommand implements Command {
    private Fan fan;

    public FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.turnOff();
    }
}

class RemoteController {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class CommandPattern {
    Light light = new Light();
    Fan fan = new Fan();

    Command lightsOnCommand = new LightsOnCommand(light);
    Command lightsOffCommand = new LightsOffCommand(light);
    Command fanOnCommand = new FanOnCommand(fan);
    Command fanOffComman = new FanOffCommand(fan);

    RemoteController remoteController = new RemoteController();

    public void run() {
        remoteController.setCommand(lightsOnCommand);
        remoteController.pressButton();

        remoteController.setCommand(lightsOffCommand);
        remoteController.pressButton();

        remoteController.setCommand(fanOnCommand);
        remoteController.pressButton();

        remoteController.setCommand(fanOffComman);
        remoteController.pressButton();
    }
}
