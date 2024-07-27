package org.example.Week1.II_miniMaxSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        miniMaxSum(arr);

        bufferedReader.close();
    }

    /**
     * Target Method
     */
    public static void miniMaxSum(List<Integer> arr) {
        /*
         //Solution with Stream API
         OptionalInt maxValue = arr.stream().mapToInt(Integer :: intValue).max();
         OptionalInt minValue = arr.stream().mapToInt(Integer :: intValue).min();
         Long generalSum = arr.stream().mapToLong(Integer :: longValue).sum();

         System.out.println((generalSum - maxValue.getAsInt()) + "  " + (generalSum - minValue.getAsInt()));
         */

        //Solution with general
        Integer maxValue = 0;
        Integer minValue = 0;
        Long generalSum = 0L;

        for (int i = 0; i < arr.size(); i++) {
            generalSum += arr.get(i);

            if (i == 0) {
                maxValue = arr.get(i);
                minValue = arr.get(i);
                continue;
            }

            if (minValue > arr.get(i)) {
                minValue = arr.get(i);
            }

            if (maxValue < arr.get(i)) {
                maxValue = arr.get(i);
            }
        }

        System.out.println((generalSum - Long.valueOf(maxValue)) + " " + (generalSum - Long.valueOf(minValue)));
    }

    /****** Test Case ******

     1 2 3 4 5

     ***********************/
}
