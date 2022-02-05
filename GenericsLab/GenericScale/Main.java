package GenericsLab.GenericScale;

/*
Create a class Scale<T>; that holds two elements - left and right. The scale should receive the elements through its
single constructor:
 Scale(T left, T right)
The scale should have a single method:
 T getHeavier()
The greater of the two elements are heavier. The method should return null if elements are equal.
 */

public class Main {
    public static void main(String[] args) {
        Scale<Integer> scale = new Scale<>(12, 11);

        System.out.println(scale.getHeavier());
    }
}
