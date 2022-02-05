package GenericsLab.ListUtilities;

/*
Create a class ListUtils that you will use through several other exercises:
The class should have two static methods:
 T getMin(List<T> list)
 T getMax(List<T> list)
The methods should throw IllegalArgumentException if an empty list is passed.
 */

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(12);
        list.add(1);
        list.add(15);
        list.add(150);
        list.add(-150);

        System.out.println(ListUtils.getMin(list));
        System.out.println(ListUtils.getMax(list));
    }
}
