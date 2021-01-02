public class Solution_02 {

    public static void main(String[] args) {

        System.out.println(reverseLeftWords("lrloseumgh",6));


    }

    public static String reverseLeftWords(String s, int n) {

        if(s == null || n < 0 ){
            return null;
        }
        if(s.length() == 0){
            return "";
        }
        if(n == 0){
            return s;
        }

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = n; i < s.length(); i++) {
            stringBuffer.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            stringBuffer.append(s.charAt(i));
        }

        return stringBuffer.toString();



    }


}
