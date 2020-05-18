public class Solution {
    //69. Sqrt(x)
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int low = 1, high = x;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
}
