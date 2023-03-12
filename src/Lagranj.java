public class Lagranj {
    private double l = 0;
    private double f = 0;
    private int[] x = {11, 12, 13};
    private final double a = 11.5;
    private double[] y = {function(x[0]), function(x[1]), function(x[2])};
    private double function(double x) {
        return Math.pow((Math.log(x)), (9 / 2));
    }
    public double lagranj() {
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
        System.out.println(function( 11.5));
        return l;

    }
}
