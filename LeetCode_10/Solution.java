class Solution {
 
    public int fib(int n){
        int[] res = {0,1};
        if(n<2){
            return res[n];
        }
        int fibOne = 0;
        int fibTwo = 1;

        int num = 0;
        for (int i = 2; i<= n; i++) {
            // 这个是根据公式获得的，为了防止数据过大加的
            num  = (fibOne+fibTwo)%1000000007;
            fibOne = fibTwo;
            fibTwo = num;
        }

        return num;



    }

}