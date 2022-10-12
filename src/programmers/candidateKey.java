package programmers;

import java.util.*;

public class candidateKey {

    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        int result = solution(relation);

        System.out.println(result);
    }

    static String[][] table;
    static List<Set<Character>> candidateKeys;

    public static int solution(String[][] relation) {
        table = relation;
        candidateKeys = new ArrayList<>();

        String columns = "";
        for(int i = 0; i < relation[0].length; i++) {
            columns += i;
        }

        for(int i = 1; i < relation[0].length + 1; i++) {
            combination(columns, new HashSet<>(), i);
            System.out.println(candidateKeys.toString());
        }

        return candidateKeys.size();
    }

    static void combination(String columns, Set<Character> out, int r) {
        if(r == 0 && isUnique(out) && isMinimal(out)) {
            candidateKeys.add(out);
            return;
        }

        for(int i = 0; i < columns.length(); i++) {
            Set<Character> newOut = new HashSet<>(out);
            newOut.add(columns.charAt(i));
            combination(columns.substring(i + 1), newOut, r - 1);
        }
    }

    static boolean isUnique(Set<Character> key) {
        Set<String> set = new HashSet<>();
        for (String[] row : table) {
            String projection = "";
            for (char col : key) {
                projection += row[col - '0'];
            }
            if (set.contains(projection)) return false;
            else set.add(projection);
        }
        return true;
    }

    static boolean isMinimal(Set<Character> key) {
        for(Set<Character> candidateKey: candidateKeys) {
            if(key.containsAll(candidateKey)) return false;
        }
        return true;
    }
}
