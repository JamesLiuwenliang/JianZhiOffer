import java.util.*;

public class Solution {
    
    /**
     * 要考虑的内容：
     *  1.n为负数
     *  2.x为0
     *  3.高效运行
     *1.00000
     * -2147483648
     */
    public static void main(String[] args) {
        /**
         * int 的范围是 -2147483648 ~ 2147483647,所以-2147483648的abs结果还是-2147483648。最好用long类型
         */
        System.out.println(myPow(1.0, -2147483648));
    }

    public static double myPow(double x, long n) {

        double result = 0.0;
        if(Double.compare(x,0.0) == 0){
            return 0.0;
        }

        long abs_n = Math.abs(n) ;

        result = myPowEngine(x,abs_n);

        if(n <0 ){
            result = 1.0/result;
        }

        return result;



    }

    // 在这个函数上加速
    private static double myPowEngine(double x ,long n){

        if(n == 0){
            return 1;
        }
        if(n== 1){
            return x;
        }

        double result = myPowEngine(x,n>>1);
        result *= result;

        if((n & 0x1) == 1){
            result *= x;
        }


        return result;
    }

    



}