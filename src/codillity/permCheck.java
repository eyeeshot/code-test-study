package codillity;

import java.util.*;

public class permCheck {

    public static void main(String[] args)  {

        int[] A = {4, 1, 3};
        int result = solution(A);
        System.out.println(result);

    }

    public static int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();

        for (int a : A) {
            set.add(a);
        }

        for (int i = 0; i < A.length; i++) {
            if (!set.contains(i + 1)) return 0;
        }

        return 1;
    }
}