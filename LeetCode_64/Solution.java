
// 这题其实挺难的，可以用做复习Cpp的特性的题
public class Solution {
    
    public static int res = 0;

    public static void main(String[] args) {
        System.out.println(sumNums(9));

    }

    public static int sumNums_LeetCode(int n){
        boolean x = n > 1 && sumNums_LeetCode(n - 1) > 0;
        res += n;

        return res;

    }

    public static int sumNums(int n) {

        if(n <= 0){
            return 0;
        }
        return (1+n) * n / 2;

    }
}
