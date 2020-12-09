public class Solution {

    public static void main(String[] args) {

        // 依次遍历每一位，分为 high cur low，权重digit
        // cur = 0: high * digit
        // cur = 1: high * digit + low + 1
        // cur = 2,.. : (high+1) * digit
        System.out.println(countDigitOne(109));

    }

    public static int countDigitOne(int n) {

        if(n<1){
            return 0;
        }
        if(n<10){
            return 1;
        }

        String stringNum = Integer.toString(n);
        int result = 0;


        for (int i = 0; i < stringNum.length(); i++) {

            char cur = stringNum.charAt(i);
            int high = toHigh(stringNum , i);
            int low = toLow(stringNum,i);
            int digit = (int) Math.pow(10,stringNum.length()-i-1);

            if(cur == '0'){
                result += high * digit;
            }else if(cur == '1'){
                result += high * digit + low + 1;
            }else{
                result += (high+1) * digit;
            }


        }

        return result;

    }

    private static int toHigh(String str , int index){
        String substring = str.substring(0,index);
        return substring.length() == 0 ? 0 : Integer.decode(substring);

    }

    private static int toLow(String str,int index){
        String substring = str.substring(index+1,str.length());
        while(substring.startsWith("0")){
            substring = substring.substring(1,substring.length());
        }
        return substring.length() == 0 ? 0 : Integer.decode(substring);
    }




}
