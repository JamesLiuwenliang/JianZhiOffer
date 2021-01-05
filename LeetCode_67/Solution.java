import java.util.LinkedList;

public class Solution {

    // 全局变量判断是真的0还是是违法输入
    private static boolean ErrorisFalse_0isTrue = true;

    public static void main(String[] args) {

        String str = "-91283472332";
        String str02 = "";
        String str03 = " ";

        System.out.println(strToInt(str03));

        System.out.println(strToInt_Book(str03));


    }
    public static  int strToInt(String str){
        if(str == null){
            return 0;
        }



        str = str.trim();
        if(str.length() == 0){
            return 0;
        }

        int result = 0;
        int carry = 0;
        LinkedList<Character> linkedList = new LinkedList<>();

        boolean signal = true;
        int i = 0;

        if(str.charAt(i) == '-' ){
            signal = false;
            i++;
        }else if(str.charAt(i) == '+'  ){
            i++;
        }else if(str.charAt(i) > '9' || str.charAt(i) < '0' ){
            return 0;
        }

        if(i>= str.length()){
            return 0;
        }

        for (; i < str.length(); i++) {

            char c = str.charAt(i);

            if(c <= '9' && c >= '0'){
                linkedList.add(c);
            }else{
                break;
            }

        }

        carry = linkedList.size()-1;


        if(signal == false){

        }
        if(signal == true) {
            for (Character character : linkedList) {
                int tmpNum = character - '0';

                result += tmpNum * Math.pow(10, carry--);
            }

        }else{
            result = 0;
            for (Character character : linkedList) {
                int tmpNum = character - '0';

                result -= tmpNum * Math.pow(10, carry--);
            }

        }
        return result;





    }

    public static  int strToInt_Book(String str) {
        if(str == null ){
            ErrorisFalse_0isTrue = false;
            return 0;
        }

        if(str.length() == 0){
            return 0;
        }

        char[] chars = str.toCharArray();
        int indexChars = 0;


        while(indexChars < str.length() && chars[indexChars] == ' '){
            indexChars++;
        }

        int sign = 1;

        if(indexChars < str.length() && chars[indexChars] == '+'){
            indexChars++;
        }else if(indexChars < str.length() && chars[indexChars] == '-'){
            indexChars++;
            sign = -1;
        }

        long result = 0;

        while(indexChars != str.length()){

            if(chars[indexChars] >= '0' && chars[indexChars]<= '9'){

                result = result*10 + sign * (chars[indexChars] - '0');

                // 边界条件的判断
                if( (sign == -1 && result < Integer.MIN_VALUE) || (sign == 1 && result > Integer.MAX_VALUE)){

                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }

                indexChars++;


            }else{

                break;
            }


        }

        return (int)result;



    }

}
