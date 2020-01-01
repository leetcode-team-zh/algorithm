package leetcode.d165;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");

        for(int i = 0 ; i < Math.max(v1Arr.length,v2Arr.length); i++){
            int num1 = i < v1Arr.length ? Integer.valueOf(v1Arr[i]) : 0;
            int num2 = i < v2Arr.length ? Integer.valueOf(v2Arr[i]) : 0;
            if(num1 != num2){
                return num1 > num2 ? 1 : -1;
            }
        }
        return 0;
    }
}
