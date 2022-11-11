package codillity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class permMissingElem {

    public static void main(String[] args)  {

        int[] A = {1,3,1,5};
        int result = solution(A);
        System.out.println(result);

    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] != i+1) {
                return i+1;
            }
        }

        return A.length + 1;
    }
}