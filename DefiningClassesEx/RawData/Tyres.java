package DefiningClassesEx.RawData;

public class Tyres {
    private double tyrePressure;
    private int tyreAge;

    public Tyres(double tyrePressure, int tyreAge) {
        this.tyrePressure = tyrePressure;
        this.tyreAge = tyreAge;
    }

    public double getTyrePressure() {
        return tyrePressure;
    }
}
