public class Solution {
    public String replaceSpace(StringBuffer str) {
      if(str == null || str.length() == 0){
            return "";
        }
        char[] chars = str.toString().toCharArray();
        str.setLength(0);
        for(char c : chars){
            if(c == ' '){
                str.append("%20");

            }else {
                str.append(c);
            }
        }
        return str.toString();
    }
}