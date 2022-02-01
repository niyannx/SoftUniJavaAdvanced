package DefiningClassesEx.RawData;

public class Car {
    private Model model;
    private Engine engine;
    private Cargo cargo;
    private Tyres tyre1;
    private Tyres tyre2;
    private Tyres tyre3;
    private Tyres tyre4;

    public Car(Model model, Engine engine, Cargo cargo, Tyres tyre1, Tyres tyre2, Tyres tyre3, Tyres tyre4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tyre1 = tyre1;
        this.tyre2 = tyre2;
        this.tyre3 = tyre3;
        this.tyre4 = tyre4;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tyres getTyre1() {
        return tyre1;
    }

    public Tyres getTyre2() {
        return tyre2;
    }

    public Tyres getTyre3() {
        return tyre3;
    }

    public Tyres getTyre4() {
        return tyre4;
    }
}
