package org.example.O_mockTest_week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FindTheMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = findMedian(arr);
        System.out.println(result);
        bufferedReader.close();

    }

    /*
     * Target Method
     */
    public static int findMedian(List<Integer> arr) {
        List<Integer> sortedList = arr.stream().sorted().collect(toList());
        int size = sortedList.size();
        int medianIndex = size / 2;

        return sortedList.get(medianIndex);
    }

    /****** Test Case ******

     7
     0 1 2 4 6 5 3

     ***********************/


}
