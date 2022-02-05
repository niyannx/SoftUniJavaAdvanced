package GenericsLab.GenericScale;

public class Scale<T extends Comparable<T>> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        T heavier;

        if (left.compareTo(right) == 0) {
            heavier = null;
        } else if (left.compareTo(right) > 0) {
            heavier = left;
        } else {
            heavier = right;
        }

        return heavier;
    }
}
