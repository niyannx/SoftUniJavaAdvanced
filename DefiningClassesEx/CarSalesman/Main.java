package DefiningClassesEx.CarSalesman;

/*
Define two classes Car and Engine. A Car has a model, engine, weight, and color. An Engine has a model, power,
displacement, and efficiency. A Car's weight, color, Engine displacements, and efficiency are optional.
On the first line, you will read a number N which will specify how many lines of engines you will receive, on each of
the next N lines you will receive information about an Engine in the following format "{Model} {Power}
{Displacement} {Efficiency}". After the lines with engines, on the next line, you will receive a number M –
specifying the number of Cars that will follow, on each of the next M lines the information about a Car will follow in
the following format "{Model} {Engine} {Weight} {Color}", where the engine in the format will be the
model of an existing Engine. When creating the object for a Car, you should keep a reference to the real engine in
it, instead of just the engine's model, note that the optional properties might be missing from the formats.
Your task is to print each car (in the order you received them) and its information in the format defined below. If
any of the optional fields have not been given print "n/a" in its place instead of:
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Engine> engineMap = new HashMap<>();
        Set<Car> cars = new LinkedHashSet<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            Engine engine = createEngine(input);

            engineMap.put(engine.getModel(), engine);
        }

        n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            Car car = createCar(input, engineMap);

            cars.add(car);
        }

        printOutput(cars);
    }

    public static void printOutput(Set<Car> cars) {
        for (Car car : cars) {
            car.printInfo();
        }
    }

    public static Car createCar(String[] input, Map<String, Engine> engineMap) {
        String model = input[0];
        String engineModel = input[1];
        double weight;
        String color;

        // if there isn't an index 2, color = n/a and weight = -1
        try {
            // if the string at index 2 is numeric, then it's WEIGHT
            if (input[2].matches("[0-9.]+")) {
                weight = Double.parseDouble(input[2]);

                // if there isn't an index 3, there IS NO COLOR
                try {
                    color = input[3];
                } catch (Exception e) {
                    color = "n/a";
                }
            // if the string at index 2 ISN'T numeric, then it's COLOR and there's NO WEIGHT
            } else {
                color = input[2];
                weight = -1;
            }
        } catch (Exception e) {
            color = "n/a";
            weight = -1;
        }

        Engine engine = engineMap.get(engineModel);

        return new Car(model, engine, weight, color);
    }

    public static Engine createEngine(String[] input) {
        String model = input[0];
        int power = Integer.parseInt(input[1]);
        int displacement;
        String efficiency;


        // if there isn't an index 2, efficiency = n/a and displacement = -1
        try {
            // if the string at index 2 is numeric, then it's DISPLACEMENT
            if (input[2].matches("[0-9.]+")) {
                displacement = Integer.parseInt(input[2]);

                // if there isn't an index 3, there IS NO EFFICIENCY
                try {
                    efficiency = input[3];
                } catch (Exception e) {
                    efficiency = "n/a";
                }
                // if the string at index 2 ISN'T numeric, then it's EFFICIENCY and there's NO DISPLACEMENT
            } else {
                efficiency = input[2];
                displacement = -1;
            }
        } catch (Exception e) {
            efficiency = "n/a";
            displacement = -1;
        }

        return new Engine(model, power, displacement, efficiency);
    }
}
