

public class Solution {

    public static void main(String[] args) {

        System.out.println(add(-1,-1));
    }

//    写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
    public static int add(int a, int b) {

        // 加法运算不讨论进位和的时候 与 异或运算 规律相同，进位和 与运算 规律相同（并需左移一位）。
        int sum,carry;
        do{
            sum = a ^ b;
            carry = (a & b)<<1;
            a = sum;
            // carry存储的是进位的结果
            b = carry;
        }while (b != 0);
        return a;


    }
}
