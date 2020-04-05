package alogrithm.medium;

/**
 * @author created by wuwt
 * @date 2020/4/5 9:48 上午
 * string 字符转数字 "28"->28
 **/
public class myAtoi_8 {
    public int myAtoi(String str) {
        str = str.trim();
        int result = 0;
        boolean isPos = true;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(i==0 && (c=='-'||c=='+')){
                isPos = c=='+'?true:false;
            } else if (c>='0' && c<='9'){
                // 检查溢出情况
                if(result>(Integer.MAX_VALUE - (c - '0'))/10){
                    return isPos? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result *= 10;
                result += c - '0';
            } else {
                return isPos?result:-result;
            }
        }
        return isPos?result:-result;
    }

    public static void main(String[] args) {
        String s = "words and 987";
        System.out.println(new myAtoi_8().myAtoi(s));
    }
}

