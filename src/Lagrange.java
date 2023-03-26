public class Lagrange {
    private double l = 0;
    private double f = 0;
    private int[] x = {11, 12, 13};
    private final double a = 11;
    private double[] y = {function(x[0]), function(x[1]), function(x[2])};
    private double function(int x) {
        return Math.pow((Math.log(x)), (9.0 / 2.0));
    }
    public double lagrange() {
        for (int i = 0; i < y.length; i++) {
            f = 1;
            for (int j = 0; j < y.length; j++) {
                if (i != j) {
                    f *= (a - x[j]) / (x[i] - x[j]);
                }
            }
            f *= y[i];
            l += f;
        }
        for (int i = 0; i < y.length; i++) {
            System.out.println(y[i]);
        }
        System.out.println(function((int) 11));
        return l;
    }
}
