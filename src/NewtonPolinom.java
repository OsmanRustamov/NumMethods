public class NewtonPolinom {
    private double[] x = {5, 6 ,7};
    private double d = 11.0 / 3;
    private double[] y = {Math.pow(Math.log(x[0]), d), Math.pow(Math.log(x[1]), d), Math.pow(Math.log(x[2]), d)};
    private int n = y.length;
    private final double[][] coef = new double[3][3];
    private double[][] divided_diff(double[] x, double[] y) {
        for (int i = 0; i < coef.length; i++) {
            coef[i][0] = y[i];
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                coef[i][j] = (coef[i + 1][j - 1] - coef[i][j - 1]) / (x[i + j] - x[i]);
            }
        }
        return coef;
    }
    private double newtonPolynom(double[] arr, double[] x_data, double x) {
        n = x_data.length;
        double p = arr[n - 1];
        for (int i = 1; i <= n; i++) {
            p = arr[n - i] + (x - x_data[n - i]) * p;
        }
        return p;
    }
    public void solution() {
        double[] a_s = divided_diff(x, y)[0];
        System.out.println(newtonPolynom(a_s, x, 5.5));
        System.out.println(Math.abs(Math.pow(Math.log(5.5), d) - newtonPolynom(a_s, x, 5.5)));
    }
}
