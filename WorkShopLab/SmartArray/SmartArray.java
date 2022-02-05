package WorkShopLab.SmartArray;

/*
In this workshop, we will create our own custom data structures – a custom list (SmartArray) and a custom stack.
The SmartArray will have similar functionality to a Java ArrayList that you've used before. Our SmartArray will
work only with integers for now, but after the Generics lecture from this course, you can try to change that and
make the structure generic, which means it will be able to work with any type. It will have the following
functionality:

 void add(int element) - Adds the given element to the end of the list
 int get(int index) - Returns the element at the specified position in this list
 int remove(int index) - Removes the element at the given index
 bool contains(int element) - Checks if the list contains the given element returns (True or False)
 void add(int firstIndex, int secondIndex) - Adds element at the specific index, the element at
this index gets shift to the right alongside with any following elements, increasing size
 void forEach(Consumer<Integer> consumer) - Goes through each one of the elements in the list

Feel free to implement your functionality or to write the methods by yourself.
The custom stack will also have similar functionality to the Java ArrayDeque and again, we will make it work only
with integers. Later on, we will learn how to implement it in a way that will allow us to work with any type. It will
have the following functionality:

 void push(int element) – Adds the given element to the stack
 int pop() – Removes the last added element
 int peek() – Returns the last element in the stack without removing it
 void forEach(Consumer<Integer> consumer) – Goes through each of the elements in the stack
 */

import java.util.Arrays;
import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 0;
    private static final int INITIAL_SIZE = 0;

    private int[] data; // holds the elements
    private int size; // holds the amount of elements

    public SmartArray() {
        this.size = INITIAL_SIZE;
        this.data = new int[INITIAL_CAPACITY];
    }

    public void add(int element) {
        if (this.size == this.data.length) {
            this.data = grow(this.data);
        }

        this.data[size] = element;

        this.size++;
    }

    public int get(int index) {
        return this.data[index];
    }

    public void remove(int index) {
        this.data = shrink(this.data, index);

        this.size--;
    }

    public boolean contains(int element) {
        for (int currElement : this.data) {
            if (currElement == element) {
                return true;
            }
        }
        return false;
    }

    public void add(int index, int element) {
        int[] firstPart = new int[index + 1];
        int[] secondPart = new int[this.data.length - index];

        for (int i = 0; i < index; i++) {
            firstPart[i] = this.data[i];
        }

        firstPart[firstPart.length - 1] = element;

        int currIndex = 0;
        for (int i = index; i < this.data.length; i++) {
            secondPart[currIndex] = this.data[i];
            currIndex++;
        }

        this.data = combine(firstPart, secondPart);

        this.size++;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int el : this.data) {
            consumer.accept(el);
        }
        System.out.println();
    }


    private int[] combine(int[] firstPart, int[] secondPart) {
        int[] result = new int[firstPart.length + secondPart.length];

        int currIndex = 0;
        for (int element : firstPart) {
            result[currIndex] = element;
            currIndex++;
        }

        for (int element : secondPart) {
            result[currIndex] = element;
            currIndex++;
        }

        return result;
    }

    private int[] shrink(int[] data, int indexToRemove) {
        int[] resizedArray = new int[data.length - 1];

        int currIndex = 0;

        for (int i = 0; i < data.length; i++) {
            if (i != indexToRemove) {
                resizedArray[currIndex] = data[i];
                currIndex++;
            }
        }

        return resizedArray;
    }

    private int[] grow(int[] data) {
        int[] resizedArray = new int[data.length + 1];

        System.arraycopy(data, 0, resizedArray, 0, data.length);

        return resizedArray;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.data);
    }
}
