package DefiningClassesEx.CompanyRoster;

/*
Define a class Employee that holds the following information: name, salary, position, department, email, and age.
The name, salary, position, and department are mandatory while the rest are optional.
Your task is to write a program that takes N lines of information about employees from the console and calculates
the department with the highest average salary and prints for each employee in that department his name, salary,
email, and age - sorted by salary in descending order. If an employee doesn't have an email – in place of that field
you should print &quot;n/a&quot; instead, if he doesn't have an age – print "-1" instead. The salary should be printed to two
decimal places after the separator.
 */

import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String, Department> departmentsMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            Employee employee = readEmployeeInfo(input);

            if (!departmentsMap.containsKey(employee.getDepartment())) {
                departmentsMap.put(employee.getDepartment(), new Department(employee.getDepartment()));
            }
            departmentsMap.get(employee.getDepartment()).getEmployees().add(employee);
        }

        printOutput(departmentsMap);
    }

    public static void printOutput(Map<String, Department> departmentMap) {
        Department department = getHighestSalary(departmentMap);

        System.out.println("Highest Average Salary: " + department.getName());

        department.printDepartment(department);
    }

    public static Department getHighestSalary(Map<String, Department> departmentMap) {
        return departmentMap
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();
    }

    public static Employee readEmployeeInfo(String[] input) {
        String name = input[0];
        double salary = Double.parseDouble(input[1]);
        String position = input[2];
        String department = input[3];
        String email = "n/a";
        int age = -1;

        if (input.length == 6) {
            email = input[4];
            age = Integer.parseInt(input[5]);

        } else if (input.length == 5) {
            String ageOrEmail = input[4];

            if (Pattern.matches("^[\\d]+$", ageOrEmail)) {
                age = Integer.parseInt(ageOrEmail);
            } else {
                email = ageOrEmail;
            }
        }

        return new Employee(name, salary, position, department, email, age);
    }
}
