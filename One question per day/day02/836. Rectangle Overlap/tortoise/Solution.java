package leetcode.d836;

public class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //x 的投影是否有交集 true 有
        boolean x_in = !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0]);
        //y 的投影是否有交集
        boolean y_in = !(rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);

        //x 和 y 轴的投影都有交集
        return x_in && y_in;
    }

    public static void main(String[] args) {
        new Solution().isRectangleOverlap(new int[]{4,0,6,6},new int[]{-5,-3,4,2});
    }
}
