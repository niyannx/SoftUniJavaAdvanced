package GenericsEx.CustomList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T>> {
    // fields
    private List<T> collection;

    // constructor
    public CustomList() {
        this.collection = new ArrayList<>();
    }

    // methods
    public void add(T element) {
        this.collection.add(element);
    }

    public T remove(int index) {
        return this.collection.remove(index);
    }

    public boolean contains(T element) {
        return this.collection.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstItem = this.collection.get(firstIndex);
        T secondItem = this.collection.get(secondIndex);

        this.collection.set(secondIndex, firstItem);
        this.collection.set(firstIndex, secondItem);
    }

    public long countGreaterThan(T element) {
        return this.collection.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return this.collection.stream().max(T::compareTo).get();
    }

    public T getMin() {
        return this.collection.stream().min(T::compareTo).get();
    }

    public List<T> getCollection() {
        return new ArrayList<>(this.collection);
    }

    public void setCollection(List<T> collection) {
        this.collection = collection;
    }

    public void sort() {
        this.collection = this.collection.stream().sorted().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (T t : this.collection) {
            output.append(t).append("\n");
        }
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }
}
