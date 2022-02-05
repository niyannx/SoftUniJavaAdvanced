package GenericsEx.GenericCountMethodDoubles;

import java.util.ArrayList;
import java.util.List;

public class Boxes<T extends Comparable<T>> {
    List<Box<T>> boxes;

    public Boxes() {
        this.boxes = new ArrayList<>();
    }

    public void add(Box<T> box) {
        this.boxes.add(box);
    }

    public int getNumberOfGreaterElements(T comparingElement) {
        int greaterElements = 0;

        for (Box<T> box : this.boxes) {
            if (comparingElement.compareTo(box.getItem()) < 0) {
                greaterElements++;
            }
        }

        return greaterElements;
    }
}
