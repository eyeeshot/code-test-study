package codillity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class tapeEquilibrium {

    public static void main(String[] args)  {

        int[] A = {3, 1, 2, 4, 3};
        int result = solution(A);
        System.out.println(result);

    }

    public static int solution(int[] A) {
        int result = 0;
        int totalSum = 0;
        int leftSum = 0;
        int rightSum = 0;
        List<Integer> resultList = new ArrayList<>();

        if (A.length == 0) return 0;

        for (int i = 0; i < A.length; i++) {
            totalSum += A[i];
        }

        for (int ii = 1; ii < A.length; ii++) {
            leftSum += A[ii-1];
            rightSum = totalSum - leftSum;
            resultList.add(Math.abs(leftSum - rightSum));
        }

        return (int) Collections.min(resultList);
    }
}