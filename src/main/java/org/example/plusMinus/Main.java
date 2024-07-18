package org.example.plusMinus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        plusMinus(arr);

        bufferedReader.close();
    }

    /**
     * Target Method
     */
    public static void plusMinus(List<Integer> arr) {
        int listSize = arr.size();

        long pos = arr.stream().filter(i -> i > 0).count();
        long neg = arr.stream().filter(i -> i < 0).count();
        long zero = arr.stream().filter(i -> i == 0).count();

        List<BigDecimal> result = List.of(
                BigDecimal.valueOf((double) pos / listSize).setScale(6, RoundingMode.HALF_UP),
                BigDecimal.valueOf((double) neg / listSize).setScale(6, RoundingMode.HALF_UP),
                BigDecimal.valueOf((double) zero / listSize).setScale(6, RoundingMode.HALF_UP)

        );

        System.out.println(result);
    }
}