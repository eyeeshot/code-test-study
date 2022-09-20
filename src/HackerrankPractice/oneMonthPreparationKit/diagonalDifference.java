package HackerrankPractice.oneMonthPreparationKit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class diagonalDifference {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(0,new ArrayList<Integer>(){{add(11);add(2);add(4);}});
        arr.add(1,new ArrayList<Integer>(){{add(4);add(5);add(6);}});
        arr.add(2,new ArrayList<Integer>(){{add(10);add(8);add(-12);}});

        int result = diagonalDifference(arr);

        System.out.println(result);
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int rightSum = 0;
        int leftSum = 0;
        int arrMax = arr.size() - 1;
        for (int i=0; i < arr.size(); i++) {
            rightSum = rightSum + (arr.get(i)).get(i);
            leftSum = leftSum + (arr.get(i)).get(arrMax - i );
        }

        return Math.abs(rightSum - leftSum);

    }
}
