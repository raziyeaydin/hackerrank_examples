package org.example.III_timeConversion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = timeConversion(s);
        System.out.println(result);

        bufferedReader.close();
    }

    /**
     * Target Method
     */
    public static String timeConversion(String s) {
        String sHour = "";
        String minute = "";
        String second = "";
        if (s != null && s.length() == 10) {
            String[] hms = s.substring(0, 8).split(":");

            //general syntax check
            if (hms.length != 3) {
                return "This is not the correct time syntax";
            }
            if (hms[0].length() != 2 || hms[1].length() != 2 || hms[2].length() != 2) {
                return "This is not the correct time syntax";
            }
            if (Integer.valueOf(hms[0]) > 12 || Integer.valueOf(hms[1]) > 60 || Integer.valueOf(hms[2]) > 60) {
                return "This is not the correct time syntax";
            }

            int iHour = Integer.valueOf(hms[0]);
            minute = hms[1];
            second = hms[2];
            if (s.contains("PM")) {
                if (iHour < 12) {
                    iHour += 12;
                }
                sHour = String.valueOf(iHour);
            } else if (s.contains("AM")) {
                if (iHour == 12) {
                    iHour = 0;
                }
                sHour = String.valueOf(iHour);
            } else {
                return "This is not the correct time syntax";
            }

            /**
             * StringBuilder and StringBuffer are Mutable.
             * Using one of them ensures that the same object in heap memory is modified, rather than creating a new object for each modification or appending operation.
             */
            StringBuilder result = new StringBuilder();
            result = result.append(sHour.length() < 2 ? "0".concat(sHour) : sHour).append(":").append(minute).append(":").append(second);
            return result.toString();
        } else {
            return "This is not the correct time syntax";
        }
    }

    /****** Test Case ******

     12:40:22AM

     ***********************/
}
