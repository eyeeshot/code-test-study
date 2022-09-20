package HackerrankPractice.oneMonthPreparationKit;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lonelyInteger {
    public static void main(String[] args) throws IOException {
        Stream<Integer> integerStream = Stream.of(34 ,95, 34, 64, 45, 95, 16, 80, 80, 75, 3, 25, 75, 25, 31, 3, 64, 16, 31);
        List<Integer> a = integerStream.collect(Collectors.toList());
        int result = lonelyinteger(a);
        System.out.println(result);
    }

    public static int lonelyinteger(List<Integer> a) {
        // Write your code here
        LinkedHashMap<Integer,Integer> hm = new LinkedHashMap<>();
        int result = 0;

        for (Integer i : a) {
            hm.put(i, hm.getOrDefault(i,0) + 1);
        }

        for (Integer key : hm.keySet() ){
            if ( hm.get( key ).equals(1) ){
                result = key;
            }
        }
        return result;
    }

}
