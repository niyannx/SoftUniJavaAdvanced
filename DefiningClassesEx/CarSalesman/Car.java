package DefiningClassesEx.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private double weight;
    private String color;

    public Car(String model, Engine engine, double weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void printInfo() {
        System.out.println(this.model + ":");
        System.out.println(this.engine.getModel() + ":");
        System.out.println("Power: " + this.engine.getPower());

        if (this.engine.getDisplacement() == -1) {
            System.out.println("Displacement: n/a");
        } else {
            System.out.println("Displacement: " + this.engine.getDisplacement());
        }

        System.out.println("Efficiency: " + this.engine.getEfficiency());

        if (this.weight == -1) {
            System.out.println("Weight: n/a");
        } else {
            System.out.printf("Weight: %.0f\n", this.weight);
        }

        System.out.println("Color: " + this.color);
    }
}
