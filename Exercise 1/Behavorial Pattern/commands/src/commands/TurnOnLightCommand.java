package commands;

import devices.Light;

public class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        if (light == null) {
            throw new IllegalArgumentException("Light cannot be null");
        }
        this.light = light;
    }

    @Override
    public void execute() {
        try {
            light.turnOn();
        } catch (Exception e) {
            System.err.println("Failed to execute command: " + e.getMessage());
        }
    }
}
