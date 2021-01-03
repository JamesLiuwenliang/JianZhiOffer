

public class Solution {

    public static void main(String[] args) {
        System.out.println(sumNums(9));

    }

    public static int sumNums(int n) {

        if(n <= 0){
            return 0;
        }
        return (1+n) * n / 2;

    }
}
