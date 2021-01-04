

public class Solution {

    public static void main(String[] args) {

        System.out.println(add(-1,-1));
    }

//    写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
    public static int add(int a, int b) {

        int sum,carry;
        do{
            sum = a ^ b;
            carry = (a & b)<<1;
            a = sum;
            b = carry;
        }while (b != 0);
        return a;


    }
}
