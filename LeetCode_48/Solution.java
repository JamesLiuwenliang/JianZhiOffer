public class Solution {

    public static void main(String[] args) {

        int result = lengthOfLongestSubstring("pwwkew");
        result = lengthOfLongestSubstring_Book("pwwkew");

        System.out.println(result);

    }
    public static  int lengthOfLongestSubstring(String s) {

        if(s.length() == 0 || s==null){
            return 0;
        }
        
        StringBuffer[] dpStrings = new StringBuffer[s.length()+1];

        char[] chars = s.toCharArray();
        dpStrings[0] = new StringBuffer("");


        dpStrings[0].append( chars[0]);
        int maxLength = 0;


        for (int i = 0; i < s.length(); i++) {
            char tmpChar = chars[i];

            if(dpStrings[i].toString().contains(String.valueOf(tmpChar)) ){
                int tmpIndex = dpStrings[i].lastIndexOf(String.valueOf(tmpChar));
                dpStrings[i+1] = dpStrings[i].delete(0,tmpIndex+1);
                dpStrings[i+1].append(tmpChar);

            }else{
                dpStrings[i+1] = dpStrings[i];
                dpStrings[i+1].append(tmpChar);
            }

            maxLength = Math.max(dpStrings[i+1].length(),maxLength);

        }

        return maxLength;
    }

    // 此方法只适合处理全是字母的方案
    public static  int lengthOfLongestSubstring_Book(String s){

        int curLength = 0;
        int maxLength = 0;
        int[] position = new int[26];

        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            // 记录这个字符上次出现的位置
            int preIndex = position[s.charAt(i)-'a'];

            if(preIndex<0 || i-preIndex > curLength){
                ++curLength;
            }else{
                if(curLength > maxLength){
                    maxLength = curLength;
                }
                curLength = i-preIndex;
            }
            position[s.charAt(i)-'a'] = i;

        }

        if(curLength>maxLength){
            maxLength = curLength;
        }

        return maxLength;


    }


}
