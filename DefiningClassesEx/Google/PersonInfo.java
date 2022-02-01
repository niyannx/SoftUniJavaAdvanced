package DefiningClassesEx.Google;

import java.util.ArrayList;
import java.util.List;

public class PersonInfo {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parents> parents;
    private List<Children> children;

    public PersonInfo(String name) {
        this.name = name;
        this.company = null;
        this.car = null;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addToListOfPokemons(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void addToListOfParents(Parents parent) {
        this.parents.add(parent);
    }

    public List<Children> getChildren() {
        return children;
    }

    public void addToListOfChildren(Children child) {
        this.children.add(child);
    }

    public StringBuilder getPersonInfo() {
        StringBuilder builder = new StringBuilder();

        builder.append(name).append(System.lineSeparator());

        builder.append("Company:").append(System.lineSeparator());
        if (company != null) {
            builder.append(company).append(System.lineSeparator());
        }

        builder.append("Car:").append(System.lineSeparator());
        if (car != null) {
            builder.append(car).append(System.lineSeparator());
        }

        builder.append("Pokemon:").append(System.lineSeparator());
        for (Pokemon pokemon : pokemons) {
            builder.append(pokemon).append(System.lineSeparator());
        }

        builder.append("Parents:").append(System.lineSeparator());
        for (Parents parent : parents) {
            builder.append(parent).append(System.lineSeparator());
        }

        builder.append("Children:").append(System.lineSeparator());
        for (Children child : children) {
            builder.append(child).append(System.lineSeparator());
        }

        return builder;
    }
}
