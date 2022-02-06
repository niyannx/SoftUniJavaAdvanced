package Exams.RetakeExam15Dec2021.aquarium;

import java.util.LinkedHashSet;
import java.util.Set;

public class Aquarium {
    private Set<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size; // volume of pool

    public Aquarium(String name, int capacity, int size) {
        this.fishInPool = new LinkedHashSet<>(capacity);
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public void add(Fish fish) {
        // add if there isn't a fish with the same name
        if (!this.fishInPool.contains(fish)) {
            // add if there's enough space for it
            if (this.fishInPool.size() < this.capacity) {
                this.fishInPool.add(fish);
            }
        }
    }

    public boolean remove(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                fishInPool.remove(fish);
                return true;
            }
        }
        return false;
    }

    public Fish findFish(String name) {
        return this.fishInPool.stream().filter(fish -> fish.getName()
                        .equals(name)).findFirst()
                .orElse(null);
    }

    public String report() {
        StringBuilder report = new StringBuilder();

        report.append(String.format("Aquarium: %s ^ Size: %d", this.getName(), this.getSize()))
                .append(System.lineSeparator());

        for (Fish fish : this.fishInPool) {
            report.append(fish.toString())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
