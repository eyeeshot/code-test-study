package programmers;

import java.util.*;

public class failureRate {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int[] result = solution(N, stages);

        System.out.println(result);
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer,Integer> failure = new HashMap<>();
        Map<Integer,Integer> challenge = new HashMap<>();
        Map<Integer,Double> failureRate = new HashMap<>();

        for (int stage : stages) {
            for(int i = 1 ; i <= stage; i++) {
                if (i == stage) {
                    failure.put(i,failure.getOrDefault(i,0) + 1);
                }
                challenge.put(i,challenge.getOrDefault(i,0) + 1);
            }
        }

        for (int x = 1; x < N+1; x++) {
            if (failure.get(x) == null || challenge.get(x) == null) {
                failureRate.put(x,(double) 0);
            } else {
                failureRate.put(x,(double) failure.get(x) / challenge.get(x) );
            }
        }

        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(failureRate.entrySet());

        Collections.sort(entryList, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int y = 0;
        for(Map.Entry<Integer, Double> entry : entryList){
            answer[y] = entry.getKey();
            System.out.println("key : " + entry.getKey() + ", value : " + entry.getValue());
            y++;
        }

        return answer;
    }
}
