public class Solution {

    public static void main(String[] args) {


        int[] nums = {9,11,8,5,7,12,16,14};
        System.out.println(maxProfit(nums));

    }

    public static int maxProfit(int[] prices){
        if(prices == null){
            return -1;
        }
        if(prices.length <= 1){
            return 0;
        }

//        int[] dp = new int[prices.length];
//        int[] numMin = new int[prices.length];
//        numMin[0] = prices[0];
        int max = 0;
        int cost = prices[0];

        for(int price : prices)  {
            // 只记录前面的最小值
            cost = Math.min(price,cost);
            max = Math.max(price-cost, max );
        }



        return max;
    }


    public static int maxProfit_Violence(int[] prices){

        if(prices == null || prices.length == 0){
            return -1;
        }
        if(prices.length == 1){
            return 0;
        }

        int max = 0;

        for (int i = 0; i < prices.length-1; i++) {

            for (int j = i+1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }


        return max;

    }



}
