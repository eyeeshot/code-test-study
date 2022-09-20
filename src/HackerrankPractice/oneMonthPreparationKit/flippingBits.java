package HackerrankPractice.oneMonthPreparationKit;

import java.io.IOException;

public class flippingBits {
    public static void main(String[] args) throws IOException {

        System.out.println(flippingBits(9));
    }

    public static long flippingBits(long n) {
        String binarys = Integer.toBinaryString((int) n);
        String result = "";

        for(int i=0; i < 32 - binarys.length(); i++) {
            result = result + "1";
        }

        for(int x=0; x < binarys.length(); x++) {
            String temp = binarys.substring(x,x+1);
            if (temp.equals("0")) {
                result = result + "1";
            } else {
                result = result + "0";
            }
        }

        return Long.valueOf(result,2);
    }
}
