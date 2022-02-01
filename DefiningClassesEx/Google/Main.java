package DefiningClassesEx.Google;

/*
Google is always watching you, so it should come as no surprise that they know everything about you (even your
Pokemon collection), since you’re fantastic at writing classes, Google asked you to design a Class that can hold all
the information they need for people.
You will receive an unknown number of rows from the console until you receive the &quot;End&quot; command, on each of
those lines there will be information about a person in one of the following formats:
 "{Name} company {companyName} {department} {salary}"
 "{Name} pokemon {pokemonName} {pokemonType}"
 "{Name} parents {parentName} {parentBirthday}"
 "{Name} children {childName} {childBirthday}"
 "{Name} car {carModel} {carSpeed}"
You should structure all information about a person in a class with nested subclasses. People's names are unique -
there won't be 2 people with the same name, a person can also have only 1 company and car, but can have multiple
parents, children, and pokemons. After the command "End" is received on the next line you will receive a single
name, you should print all information about that person. Note that information can change during the input, for
instance, if we receive multiple lines which specify a person's company, only the last one should be the one
remembered. The salary must be formatted to two decimal places after the separator.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, PersonInfo> peopleMap = new HashMap<>();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");

            PersonInfo person = new PersonInfo(data[0]);

            peopleMap.putIfAbsent(person.getName(), person);


            switch (data[1]) {
                case "company":
                    Company company = readCompanyInfo(data);

                    peopleMap.get(person.getName()).setCompany(company);
                    break;

                case "pokemon":
                    Pokemon pokemon = readPokemonInfo(data);

                    peopleMap.get(person.getName()).addToListOfPokemons(pokemon);
                    break;

                case "parents":
                    Parents parent = readParentInfo(data);

                    peopleMap.get(person.getName()).addToListOfParents(parent);
                    break;

                case "children":
                    Children child = readChildInfo(data);

                    peopleMap.get(person.getName()).addToListOfChildren(child);
                    break;

                case "car":
                    Car car = readCarInfo(data);

                    peopleMap.get(person.getName()).setCar(car);
                    break;
            }

            input = scan.nextLine();
        }

        String searched = scan.nextLine();

        PersonInfo person = peopleMap.get(searched);

        System.out.println(person.getPersonInfo());
    }

    public static void printOutput(Map<String, PersonInfo> peopleMap, String searched) {
        PersonInfo person = peopleMap.get(searched);

        System.out.println(person.getName());

        System.out.println("Company:");
        if (person.getCompany() != null) {
            System.out.println(person.getCompany());
        }

        System.out.println("Car:");
        if (person.getCar() != null) {
            System.out.println(person.getCar());
        }

        System.out.println("Pokemon:");
        if (person.getPokemons().size() > 0) {
            for (Pokemon pokemon : person.getPokemons()) {
                System.out.println(pokemon);
            }
        }

        System.out.println("Parents:");
        if (person.getParents().size() > 0) {
            for (Parents parent : person.getParents()) {
                System.out.println(parent);
            }
        }

        System.out.println("Children:");
        if (person.getChildren().size() > 0) {
            for (Children child : person.getChildren()) {
                System.out.println(child);
            }
        }
    }

    public static Company readCompanyInfo(String[] data) {
        String companyName = data[2];
        String department = data[3];
        double salary = Double.parseDouble(data[4]);

        return new Company(companyName, department, salary);
    }

    public static Pokemon readPokemonInfo(String[] data) {
        String pokemonName = data[2];
        String type = data[3];

        return new Pokemon(pokemonName, type);
    }

    public static Parents readParentInfo(String[] data) {
        String parentName = data[2];
        String birthday = data[3];

        return new Parents(parentName, birthday);
    }

    public static Children readChildInfo(String[] data) {
        String childName = data[2];
        String birthday = data[3];

        return new Children(childName, birthday);
    }

    public static Car readCarInfo(String[] data) {
        String model = data[2];
        int speed = Integer.parseInt(data[3]);

        return new Car(model, speed);
    }
}
