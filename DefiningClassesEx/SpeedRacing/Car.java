package DefiningClassesEx.SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPerKM;
    private int distanceTraveled;

    public Car(String model, int fuelAmount, double fuelCostPerKM) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKM = fuelCostPerKM;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int kilometers) {
        this.fuelAmount = this.fuelAmount - kilometers * this.fuelCostPerKM;
    }

    public double getFuelCostPerKM() {
        return fuelCostPerKM;
    }

    public void setFuelCostPerKM(double fuelCostPerKM) {
        this.fuelCostPerKM = fuelCostPerKM;
    }

    public void setDistanceTraveled(int kilometers) {
        this.distanceTraveled += kilometers;
    }

    public boolean isFuelSufficient(int kilometers) {
        return this.fuelAmount - kilometers * this.fuelCostPerKM >= 0;
    }

    public void printInfo() {
        System.out.printf("%.2f %d\n", this.fuelAmount, this.distanceTraveled);
    }
}
