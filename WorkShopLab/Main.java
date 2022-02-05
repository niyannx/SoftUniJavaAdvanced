package WorkShopLab;

import WorkShopLab.SmartArray.SmartArray;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SmartArray smartArray = new SmartArray();

        while (true) {
            menu();

            String[] input = scan.nextLine().split("\\s+");

            switch (input[0]) {
                case "add":
                    try {
                        int index = Integer.parseInt(input[1]);
                        int element = Integer.parseInt(input[2]);

                        smartArray.add(index, element);
                    } catch (Exception e) {
                        int element = Integer.parseInt(input[1]);

                        smartArray.add(element);
                    }

                    System.out.println(smartArray);
                    break;
                case "get":
                    int indexToAccess = Integer.parseInt(input[1]);

                    System.out.println(smartArray.get(indexToAccess));
                    break;
                case "remove":
                    int indexToRemove = Integer.parseInt(input[1]);

                    smartArray.remove(indexToRemove);
                    System.out.println(smartArray);
                    break;
                case "contains":
                    int element = Integer.parseInt(input[1]);

                    System.out.println(smartArray.contains(element));
                    break;
                case "forEach":
                    smartArray.forEach(e -> System.out.print(e + " "));
            }
        }
    }


    public static void menu() {
        System.out.println("What would you like to do to your SmartArray?");
        System.out.println("add [element]");
        System.out.println("add [index] [element]");
        System.out.println("get [index]");
        System.out.println("remove [index]");
        System.out.println("contains [element]");
        System.out.println("forEach");
        System.out.println();
    }
}
