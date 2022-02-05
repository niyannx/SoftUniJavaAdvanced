package GenericsLab.GenericArrayCreator;

/*
Create a class ArrayCreator with a method and a single overload to it:
 static T[] create(int length, T item)
 static T[] create(Class<T> class, int length, T item)
The method should return an array with the given length and every element should be set to the given default item.
 */

public class Main {
    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();

        String[] arr1 = ArrayCreator.create(String.class, 5, "Pesho");
        String[] arr2 = ArrayCreator.create(5, "Pesho");

        for (String el : arr1) {
            System.out.println(el);
        }

        for (String el : arr2) {
            System.out.println(el);
        }
    }
}
