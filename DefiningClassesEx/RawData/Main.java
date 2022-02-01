package DefiningClassesEx.RawData;

/*
You are the owner of a courier company, and you want to make a system for tracking your cars and their cargo.
Define a class Car that holds information about the model, engine, cargo, and a collection of exactly 4 tires. The
engine, cargo, and tire should be separate classes, create a constructor that receives all information about the Car
and creates and initializes its inner components (engine, cargo, and tires).
On the first line of the input you will receive a number N - the number of cars you have, on each of the next N lines
you will receive information about a car in the format:

"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure}
{Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire3Age} {Tire4Pressure}
{Tire4Age}", where the speed, power, weight and tire age are integers, tire pressure is a double.
After the N lines, you will receive a single line with one of 2 commands "fragile" or "flammable", if the command
is &quot;fragile&quot; print all cars whose Cargo Type is &quot;fragile&quot; with a tire whose pressure is < 1 if the command is
"flammable" print all cars whose Cargo Type is "flammable" and have Engine Power > 250. The cars should be
printed in order of appearing in the input.
 */

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Set<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            Car car = collectCarInfo(input);

            cars.add(car);
        }

        String search = scan.nextLine();

        Predicate<Car> filter = generatePredicate(search);

        Consumer<Car> print = car -> System.out.println(car.getModel().getModelType());

        cars.stream()
                .filter(filter)
                .forEach(print);
    }

    public static Predicate<Car> generatePredicate(String search) {
        Predicate<Car> filter;

        if (search.equals("fragile")) {
            filter = car -> {
                if (car.getCargo().getType().equals("fragile")) {
                    if (car.getTyre1().getTyrePressure() < 1) {
                        return true;
                    }

                    if (car.getTyre2().getTyrePressure() < 1) {
                        return true;
                    }

                    if (car.getTyre3().getTyrePressure() < 1) {
                        return true;
                    }

                    return car.getTyre4().getTyrePressure() < 1;
                }
                return false;
            };
        } else {
            filter = car -> {
                if (car.getCargo().getType().equals("flamable")) {
                    return car.getEngine().getPower() > 250;
                }
                return false;
            };
        }

        return filter;
    }

    public static Car collectCarInfo(String[] input) {
        Model model = readModelInfo(input);
        Engine engine = readEngineInfo(input);
        Cargo cargo = readCargoInfo(input);

        int tyreCount = 5;
        Tyres tyre1 = readTyreInfo(input, tyreCount);
        tyreCount += 2;
        Tyres tyre2 = readTyreInfo(input, tyreCount);
        tyreCount += 2;
        Tyres tyre3 = readTyreInfo(input, tyreCount);
        tyreCount += 2;
        Tyres tyre4 = readTyreInfo(input, tyreCount);

        return new Car(model, engine, cargo, tyre1, tyre2, tyre3, tyre4);
    }

    public static Tyres readTyreInfo(String[] input, int tyreCount) {
        double tyrePressure = Double.parseDouble(input[tyreCount]);
        int tyreAge = Integer.parseInt(input[tyreCount + 1]);

        return new Tyres(tyrePressure, tyreAge);
    }

    public static Engine readEngineInfo(String[] input) {
        int engineSpeed = Integer.parseInt(input[1]);
        int enginePower = Integer.parseInt(input[2]);

        return new Engine(engineSpeed, enginePower);
    }

    public static Cargo readCargoInfo(String[] input) {
        int cargoWeight = Integer.parseInt(input[3]);
        String cargoType = input[4];

        return new Cargo(cargoType, cargoWeight);
    }

    public static Model readModelInfo(String[] input) {
        return new Model(input[0]);
    }
}
