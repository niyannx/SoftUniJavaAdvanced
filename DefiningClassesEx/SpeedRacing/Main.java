package DefiningClassesEx.SpeedRacing;

/*
Your task is to implement a program that keeps track of cars and their fuel and supports methods for moving the
cars. Define a class Car that keeps track of a car information Model, fuel amount, fuel cost for 1 kilometer, and
distance traveled. A Car Model is unique - there will never be 2 cars with the same model.
On the first line of the input, you will receive a number N - the number of cars you need to track, on each of the
next N lines you will receive information for a car in the following format "{Model} {FuelAmount}
{FuelCostFor1km}", all cars start at 0 kilometers traveled.
After the N lines, until the command &quot;End&quot; is received, you will receive commands in the following format "Drive
{CarModel} {amountOfKm}", implement a method in the Car class to calculate whether a car can move that
distance or not. If it yes, the car fuel amount should be reduced by the amount of used fuel and its distance
traveled should be increased by the amount of kilometers traveled, otherwise the car should not move (Its fuel
amount and distance traveled should stay the same) and you should print on the console &quot;Insufficient fuel
for the drive&quot;. After the &quot;End&quot; command is received, print each car in order of appearing in input and its
current fuel amount and distance traveled in the format "{Model} {fuelAmount} {distanceTraveled}",
where the fuel amount should be printed to two decimal places after the separator.
 */

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Car> carsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            Car car = readCarInfo(scan);
            carsMap.put(car.getModel(), car);
        }

        String[] input = scan.nextLine().split("\\s+");

        while (!input[0].equals("End")) {
            String car = input[1];
            int kilometers = Integer.parseInt(input[2]);

            if (carsMap.get(car).isFuelSufficient(kilometers)) {
                carsMap.get(car).setFuelAmount(kilometers);
                carsMap.get(car).setDistanceTraveled(kilometers);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }

            input = scan.nextLine().split("\\s+");
        }

        for (Map.Entry<String, Car> entry : carsMap.entrySet()) {
            System.out.printf("%s ", entry.getKey());
            entry.getValue().printInfo();
        }
    }

    public static Car readCarInfo(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");

        String model = input[0];
        int fuelAmount = Integer.parseInt(input[1]);
        double fuelCostPerKM = Double.parseDouble(input[2]);

        return new Car(model, fuelAmount, fuelCostPerKM);
    }
}
