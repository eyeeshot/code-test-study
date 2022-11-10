package codillity;

import java.util.HashMap;

public class cyclicRotation {

    public static void main(String[] args)  {
        int[] A = {};
        int K = 1;

        int[] result = solution(A,K);

        for (int x: result) {
            System.out.println(x);
        }

    }

    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int[] result = A;

        if (result.length > 0 ) {
            for(int i=0; i < K; i++) {
                int temp = result[result.length -1];
                for (int x= result.length-1 ; x >= 1 ; x--) {
                    result[x] = result[x-1];
                }
                result[0] = temp;
            }
        }

        return result;
    }
}