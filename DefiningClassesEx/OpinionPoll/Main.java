package DefiningClassesEx.OpinionPoll;

/*
Create Person class with two fields String name and int age. Write a program that reads from the console N lines of
personal information and then prints all people whose age is more than 30 years, sorted in alphabetical order.
Note: you can use the stream() to filter people.
 */

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Predicate<Person> peopleOver30 = person -> person.getAge() > 30;
        Consumer<Person> print = person -> System.out.printf("%s - %d\n", person.getName(), person.getAge());
        
        int n = Integer.parseInt(scan.nextLine());

        ArrayList<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            
            people.add(new Person(name, age));
        }
        
        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .filter(peopleOver30)
                .forEach(print);
    }
}
