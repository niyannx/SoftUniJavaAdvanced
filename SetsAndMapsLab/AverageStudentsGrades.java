package SetsAndMapsLab;

/*
Write a program, which reads the name of a student and their grades and adds them to the student record, then
prints grades along with their average grade – ordered the output by the names of the students.
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, ArrayList<Double>> grades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            String name = input[0];
            double grade = Double.parseDouble(input[1]);

            if (!grades.containsKey(name)) {
                grades.put(name, new ArrayList<>());
            }
            grades.get(name).add(grade);
        }

        printMap(grades);
    }

    public static void printMap(Map<String, ArrayList<Double>> map) {
        for (Map.Entry<String, ArrayList<Double>> entry : map.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());

            double average = 0;
            for (int i = 0; i < map.get(entry.getKey()).size(); i++) {
                System.out.printf("%.2f ", map.get(entry.getKey()).get(i));
                average += map.get(entry.getKey()).get(i);
            }

            average = average / map.get(entry.getKey()).size();
            System.out.printf("(avg: %.2f)\n", average);
        }
    }
}
