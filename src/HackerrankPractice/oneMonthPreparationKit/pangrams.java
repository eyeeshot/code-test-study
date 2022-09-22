package HackerrankPractice.oneMonthPreparationKit;

import java.io.IOException;
import java.util.Locale;

public class pangrams {
    public static void main(String[] args) throws IOException {
        String s = "We promptly judged antique ivory buckles for the prize";

        String result = pangrams(s);
        System.out.println(result);
    }

    public static String pangrams(String s) {
        // Write your code here
        String text = s.trim().toLowerCase(Locale.ROOT);
        String result = "pangram";
        for(char i='a'; i<='z'; i++) {
            if(!text.contains(String.valueOf(i))) {
                result = "not pangram";
                break;
            }
        }

        return result;
    }
}
