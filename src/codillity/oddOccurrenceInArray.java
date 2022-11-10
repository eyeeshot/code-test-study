package codillity;

import java.util.HashMap;
import java.util.HashSet;

public class oddOccurrenceInArray {

    public static void main(String[] args)  {
        int[] A = {};

        int result = solution(A);


        System.out.println(result);

    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int number: A) {
            if (set.contains(number)){
                set.remove(number);
            } else {
                set.add(number);
            }
        }

        return set.iterator().next();
    }
}