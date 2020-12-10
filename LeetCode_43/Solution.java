public class Solution {

    public static void main(String[] args) {

        // 依次遍历每一位，分为 high cur low，权重digit
        // cur = 0: high * digit
        // cur = 1: high * digit + low + 1
        // cur = 2,.. : (high+1) * digit
        int n = 12306;
        System.out.println(countDigitOne_Book(n));
        System.out.println(countDigitOne(n));

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

    public static int countDigitOne_Book(int n){
        if(n<1){
            return 0;
        }
        if(n<10){
            return 1;
        }

        char[] chars = Integer.toString(n).toCharArray();

        return countDigitOne_BookHelper(chars);

    }

    public static int countDigitOne_BookHelper( char[] chars){

        if(chars == null ){
            return 0;
        }

        int first = chars[0] -'0';
        if(chars.length == 1 && first == 0){
            return 0;
        }
        if(chars.length == 1 && first > 0){
            return 1;
        }

        // 用来获得除第一位以外的全部字符
        char[] newchars = new char[chars.length-1];
        for (int i = 1; i < chars.length; i++) {
            newchars[i-1] = chars[i];
        }

        // 假设数字是'21345'

        // numFirstDigit是数字10000-19999的第一位中的数目
        int numFirstDigit = 0;
        if(first > 1){
            
            // 首位大于1，意味着有10000-19999首位一直为"1"的时候
            numFirstDigit =(int) Math.pow(10,chars.length-1);
            
        }else if(first ==1){
            
            // 首位等于1，（假设是1345）意味着只有1000-1345这些才是1，即345+1个"1"
            // C语言 : atoi(strN+1) + 1;
            numFirstDigit = 1 + helper(newchars);
        }

        // numOtherDigits是1346-21345除第一位之外的数位中的数目
        // 书上有写，判断首位之外出现"1"的次数公式 : 首位 * (length-1) * 10^(length-2)
        int numOtherDigits = first * (chars.length - 1) * (int)Math.pow(10,chars.length-2);

        // numRecursive是1-1345中的数目
        // 递归遍历
        int numRecursive = countDigitOne_BookHelper(newchars);

        return numOtherDigits + numRecursive + numFirstDigit;
    }

    private static int helper( char[] newChars){
        if(newChars == null){
            return 0;
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < newChars.length; i++) {
            stringBuffer.append(newChars[i]);
        }
        String substring = stringBuffer.toString();

        while(substring.startsWith("0")){
            substring = substring.substring(1,substring.length());
        }

        if (substring.length() == 0){
            return 0;
        }
        return Integer.decode(substring);



    }



}
