package programmers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class intStringWord {
    static HashMap<String, ArrayList<Integer>> scoreMap;
    static int[] answer;
    static String[] strKey;
    static String[] strInfo;
    static int score;

    public static void main(String[] args)  {
        long minPushNo = 0;
        long minPushNo2 = 0L;

        System.out.println(minPushNo);
        System.out.println(minPushNo2);


        String s = "2three45sixseven";
        int result = solution(s);

        System.out.println(result);

    }

    public static int solution(String s) {
        int answer = 0;
        String[] word = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        String temp = s;
        for (int i=0; i < word.length; i++) {
            temp = temp.replace(word[i],String.valueOf(i));
        }
        answer= Integer.parseInt(temp);


        return answer;
    }
}
