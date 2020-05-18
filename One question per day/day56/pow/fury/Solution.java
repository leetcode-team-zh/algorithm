
public class Solution {
    public double pow(double x, int N) {
        if (N == 0) {
            return 1.0;
        }
        double y = pow(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        int N = n;
        return N >= 0 ? pow(x, N) : 1.0 / pow(x, -N);
    }

}
