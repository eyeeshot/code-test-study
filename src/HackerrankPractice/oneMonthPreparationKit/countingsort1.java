package HackerrankPractice.oneMonthPreparationKit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class countingsort1 {
    public static void main(String[] args) throws IOException {
        String text = "63 25 73 1 98 73 56 84 86 57 16 83 8 25 81 56 9 53 98 67 99 12 83 89 80 91 39 86 76 85 74 39 25 90 59 10 94 32 44 3 89 30 27 79 46 96 27 32 18 21 92 69 81 40 40 34 68 78 24 87 42 69 23 41 78 22 6 90 99 89 50 30 20 1 43 3 70 95 33 46 44 9 69 48 33 60 65 16 82 67 61 32 21 79 75 75 13 87 70 33";
        List<Integer> arr = new ArrayList<>();
        for (String s : text.split(" ")) {
            Integer num = Integer.valueOf(s);
            arr.add(num);
        }

        List<Integer> result = countingSort(arr);

        System.out.println(result);
    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        HashMap<Integer,Integer> containsCnt = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int index = 0; index < arr.size(); index++)
        {
            int numb = index;
            result.add(IntStream.range(0, arr.size()).filter(x -> arr.get(x) == numb).toArray().length);
        }

        return result;
    }
}
