package codillity;

import java.util.HashSet;

public class jumpFrog {

    public static void main(String[] args)  {

        int result = solution(3, 999111321, 7);
        System.out.println(result);

    }
    public static int solution(int X, int Y, int D) {
        // write your code in Java SE 8
        int distance = Y-X;
        if (distance <= 0) return 0;

        double jump = distance / (double) D;

        return (int) Math.ceil(jump);
    }
}