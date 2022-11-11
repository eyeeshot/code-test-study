package codillity;

import java.util.*;

public class frogRiverOne {

    public static void main(String[] args)  {

        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        int X = 5;
        int result = solution(X,A);
        System.out.println(result);

    }

    public static int solution(int X,int[] A) {
        int result = -1;
        HashSet<Integer> check = new HashSet<>();

        for (int i=1; i <= X; i++) {
            check.add(i);
        }

        for (int x=0; x < A.length; x++) {
            if (check.contains(A[x])) {
                check.remove(A[x]);
            }

            if (check.isEmpty()) {
                return x;
            }
        }

        return result;
    }
}