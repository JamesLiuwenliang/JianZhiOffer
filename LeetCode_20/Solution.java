
public class Solution {


    public static void main(String[] args) {

        System.out.println(isNumber("3"));
        System.out.println(isNumberFromLeetCode("3"));
    }

    public static boolean isNumberFromLeetCode (String s ){
        if (s == null || s.length() == 0) return false;
        //去掉首位空格
        s = s.trim();

        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;

        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i) <='9' && s.charAt(i)>='0'){
                numFlag = true;

                // 判定为'.',但需要没出现过'.'和'E'
            }else if(s.charAt(i) == '.' && !dotFlag && !eFlag){
                dotFlag = true;

                // 判断为'e',但需要没出现过'e'且出现过数字
            }else if( (s.charAt(i) == 'E' || s.charAt(i) == 'e') && !eFlag && numFlag ){
                eFlag = true;
                numFlag = false; // 避免123E

                // 判定±，只能出现在第一位或者E后面一位
            }else if( (s.charAt(i) == '+' || s.charAt(i) == '-') && (i==0 || s.charAt(i-1)=='e' || s.charAt(i-1) =='E')){

            }else{
                return false;
            }

        }

        return numFlag;



    }


    public static boolean isNumber(String s) {

        String floatString = null;
        String afterEString = null;
        int[] indexPtr = new int[1];

        indexPtr[0] = 0;

        // 去掉首位空格
        s = s.trim();

        if(s==null || s.length()==0 || s.contains(" ") || isError(s)){
            return false;
        }
        boolean numeric = scanInteger(s,indexPtr);
        if(s.contains(".")){

            indexPtr[0] = s.indexOf(".") + 1;


            numeric = scanUnsignedInt(s,indexPtr) || numeric;
        }


        if(s.contains("e") || s.contains("E")){
            indexPtr[0] = Math.max(s.indexOf("E"),s.indexOf("e")) + 1;
            if(indexPtr[0] >= s.length()){
                return false;
            }
            numeric = numeric && scanInteger(s,indexPtr);
        }


        return numeric && indexPtr[0] == s.length();


    }

    public static boolean scanUnsignedInt(String unsignedStr,int[] indexPtr){

        int cnt =0;
        while(indexPtr[0] < unsignedStr.length() && unsignedStr.charAt(indexPtr[0])>='0' && unsignedStr.charAt(indexPtr[0]) <='9' ){
            indexPtr[0]++;
            cnt++;
        }

        // 判断这一段是否含有整数项
        return cnt>0;
    }

    private static boolean scanInteger(String s,int []indexPtr){

        if(s.charAt(indexPtr[0])=='+' || s.charAt(indexPtr[0]) =='-'){
            indexPtr[0]++;
        }
        return scanUnsignedInt(s,indexPtr);
    }

    private static boolean isError(String s ){

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if( c >= '0' && c<='9'){
                continue;
            }else if(c == '+' || c=='-' || c=='E' || c=='.' || c=='e'){
                continue;
            }else{
                return true;
            }
        }
        return false;
    }





}
