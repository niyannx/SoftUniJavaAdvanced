package Exams.RetakeExam16Dec2020.Bakery;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Bakery(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Employee employee) {
        if (employees.size() < capacity) {
            this.employees.add(employee);
        }
    }

    public boolean remove(String name) {
        return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        int oldestAge = Integer.MIN_VALUE;
        Employee oldestEmployee = null;

        for (Employee employee : employees) {
            if (employee.getAge() > oldestAge || oldestEmployee == null) {
                oldestAge = employee.getAge();
                oldestEmployee = employee;
            }
        }

        return oldestEmployee;
    }

    public Employee getEmployee(String name) {
        Employee employee = null;

        for (Employee value : this.employees) {
            if (value.getName().equals(name)) {
                employee = value;
                break;
            }
        }

        return employee;
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append("Employees working at Bakery ").append(name).append(":").append(System.lineSeparator());

        for (Employee employee : employees) {
            sb.append(employee.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
