class Solution {
    public String replaceSpace(String s) {
        String str_add = "%20";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c==' '){
                stringBuffer.append(str_add);
            }else {
                stringBuffer.append(c);
            }
        }
        
        return stringBuffer.toString();
    }
}