public class Newton {
    private final double a = 1.0;
    private final double b = 2.0;
    private final double n = 10000;
    private double sum;
    private double h = (b - a) / n;
    private double f(double x) {
        return Math.sin(x);
    }
    public double leftRect() {
        for (int i = 0; i < n; i++) {
            sum += h * f(a + i * h);
        }
        return sum;
    }
    public double rightRect() {
        h = (b - a) / n;
        sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += h * f(a + i * h);
        }
        return sum;
    }
    public double trap() {
        h = (b - a) / n;
        sum = 0.0;
        for (int i = 1; i <= n - 1; i++) {
            sum += h * (f(a + i * h) + f(a + (i - 1)) / 2);
        }
        return sum;
    }
    public double simpson() {
        sum = f(a) + f(b);
        for (int i = 1; i < n; i++) {
            double k = 2 + 2 * (i % 2);
            sum += k * f(a + i * h);
        }
        sum *= h / 3;
        return sum;
    }
}
