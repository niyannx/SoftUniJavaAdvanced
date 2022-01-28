package FunctionalProgrammingEx;

/*
On the first line, you are given a list of numbers. On the next lines you are passed different commands that you need to
apply to all numbers in the list:
"add" -> adds 1;
"multiply" -> multiplies by 2;
"subtract" -> subtracts 1;
"print" -> prints all numbers on a new line.

The input will end with an "end" command, after which you need to print the result.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Integer> listNums = Arrays.stream(scan.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());

        String input = scan.nextLine();
        while (!input.equals("end")) {
            Function<List<Integer>, List<Integer>> func = null;
            Consumer<Integer> print = e -> System.out.print(e + " ");

            switch (input) {
                case "add":
                    func = list -> {
                        for (int i = 0; i < list.size(); i++) {
                            list.set(i, list.get(i) + 1);
                        }

                        return list;
                    };
                    break;

                case "multiply":
                    func = list -> {
                        for (int i = 0; i < list.size(); i++) {
                            list.set(i, list.get(i) * 2);
                        }

                        return list;
                    };
                    break;

                case "subtract":
                    func = list -> {
                        for (int i = 0; i < list.size(); i++) {
                            list.set(i, list.get(i) - 1);
                        }

                        return list;
                    };
                    break;

                case "print":
                    listNums.forEach(print);
                    System.out.println();
                    break;
            }

            if (func != null) {
                func.apply(listNums);
            }

            input = scan.nextLine();
        }
    }
}
