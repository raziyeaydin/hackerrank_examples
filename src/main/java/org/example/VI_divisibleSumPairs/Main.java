package org.example.VI_divisibleSumPairs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int result = divisibleSumPairs(n, k, ar);
        bufferedReader.close();
    }

    /*
     *  Target Method
     * Complete the 'divisibleSumPairs' function below.
     *
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */
    public static int divisibleSumPairs(int n, int k, List<Integer> intList) {
        int result = 0;

        for (int i = 0; i < intList.size() - 1; i++) {
            for (int j = i + 1; j < intList.size(); j++) {
                int subSum = Integer.sum(intList.get(i), intList.get(j));
                if (Integer.valueOf(0).equals(subSum % k)) {
                    System.out.println(String.format("(%d,%d) --> %d+%d=%d", i, j, intList.get(i), intList.get(j), subSum));
                    ++result;
                }
            }
        }

        System.out.println(result);
        return result;

    }

    /****** Test Case ******

     6 3
     1 3 2 6 1 2

     ***********************/

}
