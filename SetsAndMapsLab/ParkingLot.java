package SetsAndMapsLab;

/*
Write a program that:
o Records car numbers for every car that enters the parking lot.
o Removes car number when the car is out.
When the parking lot is empty, print &quot;Parking Lot is Empty&quot;.
 */

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(", ");

        Set<String> parkingLot = new LinkedHashSet<>();

        while (!input[0].equals("END")) {
            if (input[0].equals("IN")) {
                parkingLot.add(input[1]);
            } else {
                parkingLot.remove(input[1]);
            }

            input = scan.nextLine().split(", ");
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        }
    }
}
