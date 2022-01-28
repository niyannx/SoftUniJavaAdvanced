package DefiningClassesLab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Read cars objects, add them to the collection of your choice, and print each one on the console using the toString()
method. The input consists of a single integer N the number of lines representing car objects. One each line you will
read car info in the following format "{brand} {model} {horsePower}" separated by single space.
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            String brand = input[0];
            String model = input[1];
            int horsePower = Integer.parseInt(input[2]);

            Car car = new Car();

            cars.add(car);

            cars.get(i).setBrand(brand);
            cars.get(i).setModel(model);
            cars.get(i).setHorsePower(horsePower);

            System.out.println(cars.get(i).toString());
        }
    }
}
