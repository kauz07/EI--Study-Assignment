package core;

public class Satellite {
    private String orientation;
    private String solarPanelStatus;
    private int dataCollected;

    public Satellite() {
        this.orientation = "North";
        this.solarPanelStatus = "Inactive";
        this.dataCollected = 0;
    }

    public void rotate(String direction) {
        this.orientation = direction;
        System.out.println("Satellite rotated to " + direction);
    }

    public void activatePanels() {
        this.solarPanelStatus = "Active";
        System.out.println("Solar panels activated.");
    }

    public void deactivatePanels() {
        this.solarPanelStatus = "Inactive";
        System.out.println("Solar panels deactivated.");
    }

    public void collectData() {
        if ("Active".equals(this.solarPanelStatus)) {
            this.dataCollected += 10;
            System.out.println("Data collected: 10 units. Total data: " + this.dataCollected);
        } else {
            System.out.println("Cannot collect data. Solar panels are inactive.");
        }
    }

    public void displayStatus() {
        System.out.println("Satellite Status:");
        System.out.println("Orientation: " + orientation);
        System.out.println("Solar Panels: " + solarPanelStatus);
        System.out.println("Data Collected: " + dataCollected);
    }
}
