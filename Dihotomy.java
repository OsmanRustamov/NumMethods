public class Dihotomy extends Method {

    public Dihotomy(float a, float b, double e) {
        super(a, b, e);
    };

    public float dihotomy() {
        float a = getA();
        float b = getB();
        double e = getE();
        float x = getX();
        while (Math.abs(a - b) > e) {
            x = (a + b) / 2;
            if (func(x) * func(b) < 0) {
                a = x;
            }
            else {
                b = x;
            }
        }
        return x;
    };
}
