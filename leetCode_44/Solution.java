
public class Solution {

    public static void main(String[] args) {

        // 这题没整明白，纯找规律就放弃了
        int n = 1208;
        System.out.println(findNthDigit(n));

    }

    public static int findNthDigit(int n) {


        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

}
