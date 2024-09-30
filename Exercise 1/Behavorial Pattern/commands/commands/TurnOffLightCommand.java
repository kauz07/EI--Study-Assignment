package commands;

import devices.Light;

public class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        if (light == null) {
            throw new IllegalArgumentException("Light cannot be null");
        }
        this.light = light;
    }

    @Override
    public void execute() {
        try {
            light.turnOff();
        } catch (Exception e) {
            System.err.println("Failed to execute command: " + e.getMessage());
        }
    }
}
