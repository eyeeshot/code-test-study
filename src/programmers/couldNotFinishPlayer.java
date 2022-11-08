package programmers;

import java.util.*;

public class couldNotFinishPlayer {

    public static void main(String[] args)  {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String result = solution(participant,completion);

        System.out.println(result);

    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String,Integer> completionPlayers = new HashMap<>();

        for (int i = 0; i < participant.length ; i++) {
            String player = participant[i];
            if (completionPlayers.containsKey(player)) {
                int count = completionPlayers.get(player);
                completionPlayers.put(player, count+1);
            } else {
                completionPlayers.put(player,1);
            }
        }

        for(int i=0; i<completion.length; i++) {
            String player = completion[i];
            int count = completionPlayers.get(player);

            if (count == 1) {
                completionPlayers.remove(player);
            } else {
                completionPlayers.put(player, count-1);
            }
        }

        String temp = completionPlayers.keySet().toString();
        answer = temp.substring(1,temp.length()-1);

        return answer;
    }
}
