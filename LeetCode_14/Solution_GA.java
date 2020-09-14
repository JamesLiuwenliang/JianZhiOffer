import java.util.*;
import java.math.BigInteger;

// 没有考虑大数的问题
public class Solution_GA {

    public static void main(String[] args) {


        System.out.println(cuttingRope(120));
    }

    public static int cuttingRope(int n) {
        if(n<2){
            return 0;
        }else if(n==2){
            return 1;
        }else if(n==3){
            return 2;
        }
        // 当绳子的长度大于5的时候，应尽可能剪成长度为3的大小，当绳子为4的时候，再去剪成长度分别为2的绳子
        int timeOf3 = n /3;

        if( n-timeOf3*3 == 1 ){
            --timeOf3;
        }

        int timeOf2 = (n-timeOf3*3)/2;
        return (int)Math.pow(2,timeOf2) * myPow(3,timeOf3);

    }

    private static int myPow(int m, int n){
        long ans = 1;
        while((n--)>0){
            ans = ans*m;
            ans = ans%1000000007;
        }
        return (int)ans;
    }


}
