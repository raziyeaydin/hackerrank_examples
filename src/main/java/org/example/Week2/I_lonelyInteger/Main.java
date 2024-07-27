package org.example.Week2.I_lonelyInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = lonelyInteger(a);

        System.out.println(result);
        bufferedReader.close();
    }

    public static int lonelyInteger(List<Integer> numList) {
        /*
         * Solution with Stream API
         *
         * return numList.stream()
         *             .collect(Collectors.groupingBy(num -> num, Collectors.counting()))
         *             .entrySet().stream()
         *             .filter(e -> e.getValue() == 1)
         *             .map(Map.Entry::getKey)
         *             .findFirst()
         *             .orElseThrow(() -> new IllegalArgumentException("No lonely integer found"));
         */

        Map<Integer, Integer> integerMap = new HashMap<>();
        for (Integer num : numList) {
            int count = integerMap.get(num) == null ? 0 : integerMap.get(num);
            integerMap.put(num, ++count);
        }

        List<Integer> lonelyInt = integerMap.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return lonelyInt.get(0);
    }
}
