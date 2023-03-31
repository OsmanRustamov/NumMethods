public class Gauss {
    private final double[] A = {0.236927, 0.478629, 0.568889, 0.478629, 0.236927};
    private final double[] t = {-0.90618, -0.538469, 0.0, 0.538469, 0.90618};
    private double res;
    private double function(double x) {
        return 1 + Math.pow(x, 2) - 2 * x;
    }
    public double solution() {
        double b = 6;
        double a = -1;
        double n;
        for (int i = 0; i < A.length; i++) {
            n = ((a + b) / 2) + ((b - a) / 2) * t[i];
            res += A[i] * function(n);
        }
        res *= (b - a) / 2;
        return res;
    }
}