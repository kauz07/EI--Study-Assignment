package pc;

public class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;

    public Computer(String CPU, String RAM, String storage, String GPU) {
        this.CPU = CPU;
        this.RAM = RAM;
        this.storage = storage;
        this.GPU = GPU;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + ", GPU=" + GPU + "]";
    }
}
