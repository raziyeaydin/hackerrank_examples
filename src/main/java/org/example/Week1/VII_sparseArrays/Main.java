package org.example.Week1.VII_sparseArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int stringsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> strings = IntStream.range(0, stringsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        List<Integer> res = matchingStrings(strings, queries);
        res.stream().forEach(i -> System.out.println(i));

        bufferedReader.close();
    }

    /*
     * Target Method
     */
    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> result = new ArrayList<>(Collections.nCopies(queries.size(), 0));

        for (String s : strings) {
            for (int i = 0; i < queries.size(); i++) {
                if (queries.get(i).equals(s)) {
                    int val = result.get(i);
                    result.set(i, ++val);
                }
            }
        }

        return result;
    }

    /****** Test Case ******

     4
     aba
     baba
     aba
     xzxb
     3
     aba
     xzxb
     ab

     ***********************/

}
