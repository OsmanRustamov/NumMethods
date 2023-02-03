public class Method {
    private float a;
    private float b;
    private double e;
    private float x;

    public Method(float a, float b, double e) {
        this.a = a;
        this.b = b;
        this.e = e;
        this.x = x;
    }

    public void setA(float a) {
        this.a = a;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void setE(double e) {
        this.e = e;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getA() {
        return a;
    }

    public float getB() {
        return b;
    }

    public double getE() {
        return e;
    }

    public float getX() {
        return x;
    }

    public static float derivative(float x) {
        return (float) (Math.sqrt(3 - Math.log(x)));
    };
    public static float func(float x) {
        return (float) (2 * Math.log(x) + 2 * Math.pow(x, 2) - 6);
    };
}
