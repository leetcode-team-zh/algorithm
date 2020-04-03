package leetcode.d8;

public class Solution {
    //0.start 1.signed 2.number 3.end
    private final static int START = 0;
    private final static int SIGNED = 1;
    private final static int NUMBER = 2;
    private final static int END = 3;

    //        ""     +/-     [0..9]   其他
    //start   start  signed  number   end
    //signed  end    end     number   end
    //number  end    end     number   end
    //end     end    end     end      end
    private final static int[][] states = new int[][]{
            {START,SIGNED,NUMBER,END},
            {END,END,NUMBER,END},
            {END,END,NUMBER,END},
            {END,END,END,END}
    };

    public int myAtoi(String str) {
        int flag = 1;
        int ans = 0;
        char[] chars = str.toCharArray();
        int state = START;
        for(char c : chars){
            state = states[state][getCol(c)];
            if(state == NUMBER){
                int digit = c - '0';
                if(ans > (Integer.MAX_VALUE - digit) / 10){
                    return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                ans = ans * 10 + c - '0';
            }else if(state == SIGNED){
                flag = c == '+' ? 1 : -1;
            }
        }
        return flag * ans;
    }

    private int getCol(char c){
        if(c == ' '){
            return 0;
        }else if(c == '+' || c == '-'){
            return 1;
        }else if(c >= 48 && c<= 57){
            return 2;
        }else {
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("     -4193-abec"));
    }

}
