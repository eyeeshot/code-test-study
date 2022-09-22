package HackerrankPractice.oneMonthPreparationKit;

import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;

public class balancedBrackets {

    public static void main(String[] args) throws IOException {

        String s = "{[()]}";

        System.out.println(isBalanced(s));
    }

    public static String isBalanced(String s) {
        // Write your code here
        Stack<String> stack = new Stack<>();
        String[] left = {"{","[","("};
        String[] right = {"}","]",")"};
        String result = "YES";

        for (int i=0; i < s.length() ; i++) {
            String str = s.substring(i,i+1);

            if(Arrays.asList(left).indexOf(str) >= 0 || stack.empty()) {
                stack.push(str);
            } else if (Arrays.asList(right).indexOf(str) >= 0) {
                if (stack.empty()) {
                    result = "NO";
                } else {
                    String temp = stack.pop();
                    if (Arrays.asList(left).indexOf(temp) != Arrays.asList(right).indexOf(str)) {
                        result = "NO";
                    }
                }
            }
        }

        if (!stack.empty()) {
            result = "NO";
        }

        return result;
    }
}
