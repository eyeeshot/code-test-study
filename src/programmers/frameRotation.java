package programmers;

import java.io.IOException;
import java.util.Stack;

public class frameRotation {
    public static void main(String[] args) throws IOException {
        int rows = 6;
        int columns = 6;
        //yxyx
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

        int[] result = solution(rows,columns,queries);

        for (int r : result) {
            System.out.println(r);
        }

    }
    public static int[] solution(int rows, int columns, int[][] queries) {

        //rows x columns
        int[][] frames = new int[rows][columns];
        int[] answer = new int[queries.length];
        Stack<Integer> stack = new Stack<>();

        int num = 1;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < columns; c++) {
                frames[r][c] = num;
                num++;
            }
        }

        for (int q = 0; q < queries.length; q++) {
            int[] querie = queries[q];
            int min = 0;
            int x = querie[3] - querie[1];
            int y = querie[2] - querie[0];

            //first row
            for (int i = 0 ; i <= x ; i++) {
                stack.push(frames[querie[0] - 1][querie[1] + i - 1]);
            }

            //down
            for (int i = 0 ; i < y ; i++) {
                stack.push(frames[querie[0] + i][querie[3] - 1]);
            }

            //left
            for (int i = 1 ; i <= x ; i++) {
                stack.push(frames[querie[2] - 1][querie[3] - i - 1]);
            }

            //up
            for (int i = 1 ; i < y ; i++) {
                stack.push(frames[querie[2] - i - 1][querie[1] - 1]);
            }

            if (min == 0) {
                min = stack.peek();
            }

            // reWrite down
            for (int i = 0 ; i <= y ; i++) {
                frames[querie[0] + i - 1][querie[1] - 1] = stack.peek();
                min = min > stack.peek() ? stack.peek() : min;
                stack.pop();
            }

            // reWrite right
            for (int i = 1 ; i <= x ; i++) {
                frames[querie[2] - 1][querie[1] + i - 1] = stack.peek();
                min = min > stack.peek() ? stack.peek() : min;
                stack.pop();
            }

            // reWrite up
            for (int i = 1 ; i < y ; i++) {
                frames[querie[2] - i - 1][querie[3] - 1] = stack.peek();
                min = min > stack.peek() ? stack.peek() : min;
                stack.pop();
            }

            // reWrite left
            for (int i = 0 ; i < x ; i++) {
                frames[querie[0] - 1][querie[3] - i - 1] = stack.peek();
                min = min > stack.peek() ? stack.peek() : min;
                stack.pop();
            }

            answer[q] = min;
        }

        return answer;
    }
}
