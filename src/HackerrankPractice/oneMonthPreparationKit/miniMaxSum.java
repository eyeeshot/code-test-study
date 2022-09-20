package HackerrankPractice.oneMonthPreparationKit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class miniMaxSum {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                .map(Integer::parseInt)
//                .collect(toList());
//
//        miniMaxSum(arr);
//
//        bufferedReader.close();
        List<Integer> arr = Arrays.asList(256741038, 623958417, 467905213, 714532089, 938071625);
        miniMaxSum(arr);
    }

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        long maxSum = 0;
        long minSum = 0;
        long totalsum = 0;
        arr.sort(Comparator.naturalOrder());

        for (long i : arr) {
            totalsum = totalsum + i;
        }

        for (long x : arr) {
            long result = totalsum - x;
            if (result > maxSum) {
                maxSum = result;
            }
            if (result < minSum || minSum == 0) {
                minSum = result;
            }
        }

        System.out.printf(minSum + " " + maxSum);
    }
}