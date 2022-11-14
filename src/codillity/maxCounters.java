package codillity;

import java.util.*;

public class maxCounters {

    public static void main(String[] args)  {

        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int N = 5;
        int[] results = solution(N,A);

        for (int result: results) {
            System.out.println(result);
        }

    }

    public static int[] solution(int N, int[] A) {
        HashMap<Integer,Integer> map = new HashMap();
        int maxNum = 0;

        for (int i =0; i < N; i++) {
            map.put(i,0);
        }

        int[] result = new int[N];

        for (int number : A) {
            if (number > N) {
                maxNum = Collections.max(map.values());
                continue;
            }

            if ( map.get(number - 1 )< maxNum) {
                map.put(number - 1 , maxNum);
            }

            map.put(number - 1 ,map.get(number - 1 )+1);
        }

        System.out.println(map);

        int index = 0;
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            int value = mapEntry.getValue();

            if (value < maxNum) value = maxNum;
            result[index] = value;
            index++;
        }

        return result;
    }
}