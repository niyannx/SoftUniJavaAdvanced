package DefiningClassesLab.CarConstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Make proper constructors for the Car class, so you can create car objects with a different type of input information.
If you miss information about the field of type String set the value to "unknown", and for an integer, field set -1.
First, declare a constructor which takes only the car brand as a parameter:

Read information about cars the same way as the previous task, however, this time uses constructors to create the
objects, not creating an object with the default constructor. You should be able to handle different types of input, the
format will be the same as the previous task, but this time some data may be missing. For example, you can get
only the car brand – which means you have to set the car model to "unknown" and the Horsepower value to -1. There will
be lines with complete car data, declare constructor which sets all the fields.
You have to add the car objects to a collection of your choice and print the data as in the previous task. The input
will always have one or three elements on each line.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            Car car = new Car();

            cars.add(car);

            switch (input.length) {
                case 1:
                    car.setBrand(input[0]);
                    break;
                case 2:
                    car.setBrand(input[0]);
                    car.setModel(input[1]);
                    break;
                case 3:
                    car.setBrand(input[0]);
                    car.setModel(input[1]);
                    car.setHorsePower(Integer.parseInt(input[2]));
                    break;
            }

            System.out.println(car);
        }
    }
}
