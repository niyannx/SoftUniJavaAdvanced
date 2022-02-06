package Exams.Exam26Jun2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (data.size() != capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.remove(data.get(i));
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet pet = null;

        for (Pet currPet : data) {
            if (currPet.getName().equals(name) && currPet.getOwner().equals(owner)) {
                pet = currPet;
                break;
            }
        }

        return pet;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet.getName()).append(" ").append(pet.getOwner()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
