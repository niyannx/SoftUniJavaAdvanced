package GenericsLab.JarOfT;

/*
Create a class Jar<> that can store anything.
It should have two public methods:
 void add(element)
 element remove()
Adding should add on top of its contents. Remove should get the topmost element.
 */

public class Main {
    public static void main(String[] args) {
        Jar<Integer> jar = new Jar<>();

        jar.add(12);
        jar.add(13);
        jar.add(14);

        System.out.println(jar.remove());
        System.out.println(jar.remove());

        Jar<String> secondJar = new Jar<>();

    }
}
