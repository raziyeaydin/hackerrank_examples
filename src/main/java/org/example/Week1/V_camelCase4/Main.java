package org.example.Week1.V_camelCase4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> inputs = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null && !line.trim().isEmpty()) {
            inputs.add(line.trim());
        }

        List<String> outputs = convertStepByStep(inputs);
        outputs.stream().forEach(i -> System.out.println(i));

        bufferedReader.close();
    }

    public static List<String> convertStepByStep(List<String> inputs) {
        List<String> outputs = new ArrayList<>();
        for (String input : inputs) {
            String output = null;
            String[] arr = input.split(";");
            if (arr.length != 3) {
                output = input + " does not have the correct syntax";
                outputs = List.of(output);
                continue;
            }

            String splitOrCombine = arr[0];
            String methodOrClassOrVariable = arr[1];
            String sample = arr[2];

            //S: split
            if (splitOrCombine.equals("S")) {
                output = splitOperationForSecondPart(methodOrClassOrVariable, sample);
            }//C: combine
            else if (splitOrCombine.equals("C")) {
                output = combineOperationForSecondPart(methodOrClassOrVariable, sample);
            } else {
                output = input + " does not have the correct syntax";
            }
            outputs.add(output);
        }

        return outputs;
    }

    private static String splitOperationForSecondPart(String mcv, String sample) {
        String[] sampleArr = sample.split("(?=[A-Z])");
        StringBuilder sb = new StringBuilder();

        //M: method - C: class - V: variable
        if (mcv.equals("M") || mcv.equals("C") || mcv.equals("V")) {
            for (int i = 0; i < sampleArr.length; i++) {
                StringBuilder sample_i = new StringBuilder(sampleArr[i]);
                sample_i.setCharAt(0, String.valueOf(sample_i.charAt(0)).toLowerCase(Locale.ROOT).charAt(0));
                sb.append(sample_i).append(" ");
            }
        } else {
            return "This sample does not have the correct syntax";
        }
        if (sample.contains("()")) {
            sb.replace(sb.indexOf("("), sb.toString().length(), "");
        }

        return sb.toString();
    }

    private static String combineOperationForSecondPart(String mcv, String sample) {
        String[] sampleArr = sample.split(" ");
        boolean sampleStartsWithUpperCase = Character.isUpperCase(sampleArr[0].charAt(0));
        StringBuilder sb = new StringBuilder();

        //M: method - V: variable
        if (mcv.equals("M") || mcv.equals("V")) {
            for (int i = 0; i < sampleArr.length; i++) {
                StringBuilder sample_i = new StringBuilder(sampleArr[i]);
                if (i == 0) {
                    if (sampleStartsWithUpperCase) {
                        sample_i.setCharAt(0, String.valueOf(sample_i.charAt(0)).toLowerCase(Locale.ROOT).charAt(0));
                    }
                    sb.append(sample_i);
                } else {
                    sample_i = new StringBuilder(sampleArr[i]);
                    if (Character.isLowerCase(sampleArr[i].charAt(0))) {
                        sample_i.setCharAt(0, String.valueOf(sample_i.charAt(0)).toUpperCase(Locale.ROOT).charAt(0));
                    }
                    sb.append(sample_i);
                }
            }
            if (mcv.equals("M")) sb.append("()");
        }//C: class
        else if (mcv.equals("C")) {
            for (int i = 0; i < sampleArr.length; i++) {
                StringBuilder sample_i = new StringBuilder(sampleArr[i]);
                if (Character.isLowerCase(sampleArr[i].charAt(0))) {
                    sample_i.setCharAt(0, String.valueOf(sample_i.charAt(0)).toUpperCase(Locale.ROOT).charAt(0));
                }
                sb.append(sample_i);
            }
        } else {
            return "This sample does not have the correct syntax";
        }

        return sb.toString();
    }

    /****** Test Case ******

     S;M;plasticCup()
     C;V;mobile phone
     C;C;coffee machine
     S;C;LargeSoftwareBook
     C;M;white sheet of paper
     S;V;pictureFrame

     ***********************/
}
