public class Zeidel {
    private final double[][] a = {
            {3.8, 6.7, -1.2},
            {6,4, 1.3, -2.7},
            {2.4, -4.5, 3.5}
    };
    private final double[] b = {5.2, 3.8, -0.8};
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
        double[] MX = {0.0, 0.0, 0.0};
        boolean flag = true;
        int iterations = 0;
        double[] x0 = {b[0], b[1], b[2]};
        while (flag) {
            x0[0] = x0[0] * a[0][0] + x0[1] * a[0][1] + x0[2] * a[0][2] + b[0];
            x0[1] = x0[0] * a[1][0] + x0[1] * a[1][1] + x0[2] * a[1][2] + b[1];
            x0[2] = x0[0] * a[2][0] + x0[1] * a[2][1] + x0[2] * a[2][2] + b[2];
            double[] deltaX = new double[3];
            for (int i = 0; i < 3; i++) {
                deltaX[i] =x0[i] - MX[i];
            }
            double delta = max(deltaX);
            if ((delta * q / (1 - q)) < e) {
                flag = false;
            }
            MX[0] = x0[0];
            MX[1] = x0[1];
            MX[2] = x0[2];
            iterations += 1;
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(x0[i]);
        }
        System.out.println(iterations);
    }
}
