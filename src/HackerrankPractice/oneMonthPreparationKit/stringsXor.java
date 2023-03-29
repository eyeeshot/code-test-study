package HackerrankPractice.oneMonthPreparationKit;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
* Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the
* decimal value of each fraction on a new line with  places after the decimal.
* https://www.hackerrank.com/challenges/one-month-preparation-kit-strings-xor/problem
* */
public class stringsXor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();
        String t = bufferedReader.readLine();
        System.out.println(xor(s, t));

        bufferedReader.close();
    }

    public static String xor(String s, String t) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            builder.append(s.charAt(i) ^ t.charAt(i));
        }
        return builder.toString();
    }
}

