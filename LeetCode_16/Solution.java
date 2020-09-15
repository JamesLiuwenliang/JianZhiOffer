import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        System.out.println(myPow(1.0, -2147483648));
    }

    public static double myPow(double x, int n) {

        if(n==0) {
            return 1;
        }
        if(n==-1){
            return 1.0/x;
        }
        
        if((n&0x1) == 1) {
            return myPow(x*x, n>>1)*x;
        }
        else {
            return myPow(x*x, n>>1);
        }


    }

    



}