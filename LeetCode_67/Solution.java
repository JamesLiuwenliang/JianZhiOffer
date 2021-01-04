
import java.util.LinkedList;

public class Solution {


    public static void main(String[] args) {


        System.out.println(strToInt("-2147483648"));
//        "-2147483647"

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

}
