package programmers;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Map;

public class undestroyedBuilding {
    public static void main(String[] args) {

        // r,c
        int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        // type(1 : -, 2: +), r1, c1, r2, c2, degree
        int[][] skill = {{1,0,0,3,4,4}, {1,2,0,2,3,2}, {2,1,0,3,1,2}, {1,0,1,3,3,1}};

        int result = solution(board, skill);

        System.out.println(result);
    }

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;

        for (int[] phase : skill) {
            int type = phase[0];
            int r1 = phase[1];
            int c1 = phase[2];
            int r2 = phase[3];
            int c2 = phase[4];
            int degree = phase[5];
            for (int r = r1; r <= r2; r++) {
                for (int c = c1; c <= c2; c++) {
                    if (type == 1) {
                        board[r][c] = board[r][c] - degree;
                    } else {
                        board[r][c] = board[r][c] + degree;
                    }
                }
            }
        }

        for (int[] r : board) {
            for(int health : r) {
                if (health > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
