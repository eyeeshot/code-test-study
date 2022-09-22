package programmers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class lotto {
    public static void main(String[] args) throws IOException {

        int lottos[] = {44, 1, 0, 0, 31, 25};
        int win_nums[] = {31, 10, 45, 1, 6, 19};

        for(int lotto : lottos) {
            System.out.println(lotto);
        }

        solution(lottos,win_nums);
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int deleteNumCnt = 0;
        int matchNumCnt = 0;
        for(int lotto : lottos) {
            if (lotto == 0) {
                deleteNumCnt++;
            } else {
                for(int win_num : win_nums) {
                    if(win_num == lotto) {
                        matchNumCnt++;
                    }
                }
            }
        }

        answer[0] = ranking(matchNumCnt + deleteNumCnt);
        answer[1] = ranking(matchNumCnt);

        return answer;
    }

    public static int ranking(int num) {
        int ranking;

        switch (num) {
            case 2 :
                ranking = 5;
                break;
            case 3 :
                ranking = 4;
                break;
            case 4 :
                ranking = 3;
                break;
            case 5 :
                ranking = 2;
                break;
            case 6 :
                ranking = 1;
                break;
            default :
                ranking = 6;
                break;
        }

        return ranking;
    }
}
