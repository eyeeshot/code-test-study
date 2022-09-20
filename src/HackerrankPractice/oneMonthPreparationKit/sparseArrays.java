package HackerrankPractice.oneMonthPreparationKit;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class sparseArrays {
    public static void main(String[] args) throws IOException, ParseException {
        List<String> strings = new ArrayList<>();
        for (String s : new String[]{"aba", "baba", "aba","xzxb"}) {
            strings.add(s);
        }

        List<String> queries = new ArrayList<>();
        for (String s : new String[]{"aba", "xzxb", "ab"}) {
            queries.add(s);
        }

        System.out.println(matchingStrings(strings,queries));
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        LinkedHashMap<String,Integer> containsCnt = new LinkedHashMap<>();
        List<Integer> resut = new ArrayList<>();

        for(String string : strings) {
            if(queries.contains(string)) {
                containsCnt.put(string, containsCnt.getOrDefault(string, 0) + 1);
            }
        }

        for(String querie : queries) {
            resut.add(containsCnt.getOrDefault(querie,0));
        }

        return resut;
    }
}
