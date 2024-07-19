package org.example.IV_breakingTheRecords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = breakingRecords(scores);
        System.out.println(result);

        bufferedReader.close();
    }

    /**
     * Target Method
     */
    public static List<Integer> breakingRecords(List<Integer> scores) {
        /**
         * Solution with Stream API
         *
         *     int[] minMaxCounters = {0, 0}; // {maxCounter, minCounter}
         *     int[] minMaxValues = {scores.get(0), scores.get(0)}; // {max, min}
         *
         *     IntStream.range(1, scores.size()).forEach(i -> {
         *         if (scores.get(i) > minMaxValues[0]) {
         *             minMaxValues[0] = scores.get(i);
         *             minMaxCounters[0]++;
         *         }
         *         if (scores.get(i) < minMaxValues[1]) {
         *             minMaxValues[1] = scores.get(i);
         *             minMaxCounters[1]++;
         *         }
         *     });
         *
         *     return Arrays.asList(minMaxCounters[0], minMaxCounters[1]);
         */

        int max = scores.get(0);
        int min = scores.get(0);

        int maxCounter = 0;
        int minCounter = 0;

        for (Integer score : scores) {
            if (score > max) {
                max = score;
                ++maxCounter;
            }

            if (score < min) {
                min = score;
                ++minCounter;
            }
        }

        return List.of(maxCounter, minCounter);
    }
}
