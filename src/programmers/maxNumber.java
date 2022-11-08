package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class maxNumber {

    public static void main(String[] args)  {
        int[] numbers = {0, 0, 0, 0};

        String result = solution(numbers);

        System.out.println(result);

    }

    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String arrayNum[] = new String[numbers.length];

        for(int i=0; i < numbers.length; i++) {
            arrayNum[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arrayNum, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        if(arrayNum[0].equals("0")) {
            return "0";
        } else {
            for(int j=0; j<arrayNum.length; j++) {
                answer.append(arrayNum[j]);
            }
        }
        return answer.toString();
    }
}
