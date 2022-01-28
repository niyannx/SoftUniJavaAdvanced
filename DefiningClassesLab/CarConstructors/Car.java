package DefiningClassesLab.CarConstructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;

    // default constructor
    public Car() {
        this.brand = "unknown";
        this.model = "unknown";
        this.horsePower = -1;
    }

    // constructor with params
    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    // mutators
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    // methods
    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsePower);
    }
}
