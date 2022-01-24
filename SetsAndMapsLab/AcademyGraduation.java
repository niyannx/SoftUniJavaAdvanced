package SetsAndMapsLab;

/*
Write a program that:
Reads from console number of students for a track.
 Reads on pair of rows:
    o The first line is the name of the student.
    o The second line is his score for a different number of courses.
 Print on console "{name} is graduated with {average scores}".
 */

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentsGrades = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();

            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            double sum = 0;

            for (Double grade : grades) {
                sum += grade;
            }

            double average = sum / grades.length;

            studentsGrades.putIfAbsent(name, average);
        }

        studentsGrades.forEach((key, value) ->
                System.out.printf("%s is graduated with " + value + "%n", key));
    }
}
