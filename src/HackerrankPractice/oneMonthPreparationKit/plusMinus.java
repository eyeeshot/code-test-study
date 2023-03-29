package HackerrankPractice.oneMonthPreparationKit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
* Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero. Print the
* decimal value of each fraction on a new line with  places after the decimal.
* https://www.hackerrank.com/challenges/one-month-preparation-kit-plus-minus/problem
* */
public class plusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        plusMinus(arr);

        bufferedReader.close();
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int positiveCnt = 0;
        int negativeCnt = 0;
        int zeroCnt = 0;
        int totalCnt = 0;

        for(int num : arr) {
            if (num < 0) {
                negativeCnt++;
            } else if (num == 0) {
                zeroCnt++;
            } else {
                positiveCnt++;
            }
            totalCnt++;
        }

        printPercent(positiveCnt,totalCnt);
        printPercent(negativeCnt,totalCnt);
        printPercent(zeroCnt,totalCnt);
    }

    public static void printPercent(int cnt,int totalcnt){
        double result = (double) cnt / (double) totalcnt;
        System.out.println(String.format("%.6f", result));
    }
}

