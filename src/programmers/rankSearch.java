package programmers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class rankSearch {
    static HashMap<String, ArrayList<Integer>> scoreMap;
    static int[] answer;
    static String[] strKey;
    static String[] strInfo;
    static int score;

    public static void main(String[] args)  {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] result = solution(info,query);

        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] info, String[] query) {
        scoreMap = new HashMap<>();
        answer = new int[query.length];
        // info 를 이용하여 테이블 생성 - 전체 선택을 위해 - 항상 존재.
        for(int i = 0; i < info.length ; i++ ) {
            strKey = new String[4];
            strInfo = info[i].split(" ");
            score = Integer.parseInt(strInfo[4]);
            dfs(0);
        }

        for (String key : scoreMap.keySet())
            Collections.sort(scoreMap.get(key));

        int idx = 0;
        for (String q : query) {
            String[] querySplit = q.split(" and | ");
            String key = querySplit[0] + querySplit[1] + querySplit[2] + querySplit[3];

            if (!scoreMap.containsKey(key)) {
                answer[idx] = 0;
            } else {
                ArrayList<Integer> checkList = scoreMap.get(key);
                answer[idx] = checkList.size() - lowerBound(checkList, Integer.parseInt(querySplit[4]));
            }
            idx++;
        }

        return answer;
    }

    static int lowerBound(ArrayList<Integer> list, int key) {
        int left = 0, right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) < key)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    static void dfs(int lv) {
        if (lv == 4) {
            String str = String.join("", strKey);
            if (!scoreMap.containsKey(str))
                scoreMap.put(str, new ArrayList<>());
            scoreMap.get(str).add(score);
        }else {
            strKey[lv] = strInfo[lv];
            dfs(lv + 1);
            strKey[lv] = "-";
            dfs(lv + 1);
        }
    }
}
