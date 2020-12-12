

public class Solution {

    public static void main(String[] args) {

        int n = 1000000000;
        // 找规律实现
        System.out.println(findNthDigit(n));
        System.out.println("----------------------");
        // 递归实现
        System.out.println(findNthDigit_Book(n));

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
            System.out.println(count +" "+start);
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public static long findNthDigit_Book(int n){

        if(n < 0){
            return -1;
        }
        long index = n;
        System.out.println("index"+index);

        long digits = 1;

        while(true){

            long totalNumbers = countOfInteger(digits);

            if(index < totalNumbers ){
                return digitAtIndex(index,digits);
            }

            index -=  totalNumbers;
            digits ++;

        }


    }

    // 判断这一位有多少数据
    public static long countOfInteger(long digits){

        if(digits == 1){
            return 10;
        }

        return 9 * (long) Math.pow(10,digits-1) * digits;
    }

    public static long digitAtIndex(long n ,long digits){
        long number = beginNumber(digits) + n / digits;
        long indexFromRight = digits - n % digits;

        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;

    }

    // m位数的第一个数，如2位是10,3位是100
    public static long beginNumber(long digits){
        if(digits == 1){
            return 0;
        }

        return (long)Math.pow(10,digits-1);
    }



}
