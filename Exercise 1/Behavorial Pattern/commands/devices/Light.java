package devices;

import java.util.logging.Logger;

public class Light {
    private static final Logger logger = Logger.getLogger(Light.class.getName());

    public void turnOn() {
        logger.info("Light is ON");
    }

    public void turnOff() {
        logger.info("Light is OFF");
    }
}
