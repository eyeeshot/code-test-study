package programmers;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class twoQueue {
    public static void main(String[] args) {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

        int result = solution(queue1,queue2);

        System.out.println(result);
    }


    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int sumQueue1 = 0;
        int sumQueue2 = 0;
        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();

        for(int i=0; i < queue1.length; i++) {
            sumQueue1 += queue1[i];
            list1.add((long) queue1[i]);
        }

        for(int i = 0 ; i < queue2.length; i++) {
            sumQueue2 += queue2[i];
            list2.add((long) queue2[i]);
        }

        int totalSum = sumQueue1 + sumQueue2;
        int wantResult =  totalSum/2;
        if (totalSum % 2 == 1) {
            return -1;
        } else if (sumQueue1 == sumQueue2) {
            return 0;
        } else {

        }

        return answer;
    }
}
