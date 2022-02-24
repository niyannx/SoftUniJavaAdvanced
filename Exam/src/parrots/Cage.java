package parrots;

import java.util.ArrayList;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (data.size() != capacity) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : data) {
            // if the name is the same
            if (parrot.getName().equals(name)) {
                // if the parrot's available
                if (parrot.isAvailable()) {
                    parrot.setAvailable(false);
                    return parrot;
                }
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrots = new ArrayList<>();

        for (Parrot parrot : data) {
            // if the species is the one we're searching for, add
            if (parrot.getSpecies().equals(species)) {
                parrots.add(parrot);
            }
        }

        // remove them if their species is equal to the serched one
        data.removeIf(parrot -> parrot.getSpecies().equals(species));

        return parrots;
    }

    // return the count of available parrots? idk
    public int count() {
        return data.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append("Parrots available at ").append(this.name).append(":").append(System.lineSeparator());

        for (Parrot parrot : data) {
            if (parrot.isAvailable()) {
                sb.append(parrot).append(System.lineSeparator());
            }
        }

        return sb.toString();
    }
}
