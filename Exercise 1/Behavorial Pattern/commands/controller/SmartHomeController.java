package controller;

import commands.Command;

public class SmartHomeController {
    private Command command;

    public void setCommand(Command command) {
        if (command == null) {
            throw new IllegalArgumentException("Command cannot be null");
        }
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
