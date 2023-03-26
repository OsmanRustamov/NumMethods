

public class SimpleIter {
    private final double[][] a = {
            {0.8, -0.3, -0.06},
            {0.54, 0.24, -0.08},
            {0.33, -0.37, 0.25},
            {0.11, 0.03, 0.52}
    };
    private final double[] b = {-1.7, 0.81, -0.98, 0.14};
    private double[] absSum = {0, 0, 0};
    private final double e = 0.0001;
    public double norm() {
        for (int row = 0; row < a.length; row++) {
            int abssum = 0;
            for (int col = 0; col < a[row].length; col++) {
                abssum += Math.abs(a[row][col]);
            }
            absSum[row] = abssum;
        }
        double maxSum = 0;
        for (int i = 0; i < absSum[i]; i++) {
            if (absSum[i] > maxSum) {
                maxSum = absSum[i];
            }
        }
        return maxSum;
    }

    public double max(double[] arr) {
        double maxVal = 0;
        for (int i = 0; i < arr[i]; i++) {
            if (maxVal < Math.abs(arr[i])) {
                maxVal = Math.abs(arr[i]);
            };
        }
        return maxVal;
    }

    public void solution() {
        double q = norm();
        double[] x0 = b;
        boolean flag = true;
        double[] MX = {0, 0, 0};
        double[] deltaX = {0, 0, 0};
        while (flag) {
            for (int i = 0; i < a.length; i++) {
                double col = 0;
                for (int k = 0; k < b.length; k++) {
                    col += a[i][k] * b[i];
                }
                MX[i] = col + b[i];
                deltaX[i] = MX[i] - x0[i];
            }
            double delta = max(deltaX);
            if ((delta * q / (1 - q)) < e)
                flag = false;
            x0 = MX;
        }
        for (int i = 0; i < MX.length; i++) {
            System.out.println(MX[i]);
        }
    }
}