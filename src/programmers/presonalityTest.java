package programmers;

import java.util.*;

public class presonalityTest {

    public static void main(String[] args)  {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String result = solution(survey,choices);

        System.out.println(result);

    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] score = {3,2,1,0,1,2,3};
        HashMap<String,Integer> resultArray = new HashMap<>();

        for (int i = 0 ; i < survey.length; i++) {
            String[] strSplit = survey[i].split("");

            if (!resultArray.containsKey(strSplit[0])) {
                resultArray.put(strSplit[0],0);
            }

            if (!resultArray.containsKey(strSplit[1])) {
                resultArray.put(strSplit[1],0);
            }

            if (choices[i] > 3) {
                int tempChoices = choices[i] - 1;
                int tempScore = resultArray.get(strSplit[1]) + score[tempChoices];
                resultArray.put(strSplit[1],tempScore);
            }
            if (choices[i] < 3) {
                int tempChoices = choices[i]  - 1;
                int tempScore = resultArray.get(strSplit[0]) + score[tempChoices];
                resultArray.put(strSplit[0],tempScore);
            }
        }

        // 키로 정렬
        Object[] mapkey = resultArray.keySet().toArray();
        Arrays.sort(mapkey);

        System.out.println(resultArray);

        List<Map.Entry<String, Integer>> list_entries = new ArrayList<Map.Entry<String,Integer>>(resultArray.entrySet());

        Collections.sort(list_entries,
                new Comparator<Map.Entry<String,Integer>>() {
                    public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
                        return obj2.getValue().compareTo(obj1.getValue());
                    }
                });

        System.out.println(list_entries);

        return answer;
    }
}
