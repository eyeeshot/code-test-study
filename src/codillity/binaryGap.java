package codillity;

import java.util.Arrays;

public class binaryGap {

    public static void main(String[] args)  {
        int n = 328;

        int result = solution(n);

        System.out.println(result);

    }

    public static int solution(int n) {
        int answer = 0;
        int tmep = 0;

        String binary = Integer.toBinaryString(n);
        System.out.println(binary);

        for (int i=0; i < binary.length(); i++) {
            String number = binary.substring(i,i+1);
            if (number.equals("1")) {
                if (i == 0) {
                    continue;
                } else {
                    if (answer < tmep) answer = tmep;
                    tmep = 0;
                }
            } else {
                tmep++;
            }
        }

        return answer;
    }
}