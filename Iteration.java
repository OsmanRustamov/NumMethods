public class Iteration extends Method {


    public Iteration(float a, float b, double e) {
        super(a, b, e);
    };

    public float iteration() {
        float a = getA();
        float b = getB();
        double e = getE();
        float x;
        x = (a + b) / 2;
        float x0 = 0;
        while (Math.abs(x - x0) > e) {
            x0 = x;
            x = derivative (x);
        }
        return x;
    }
}
