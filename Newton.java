public class Newton extends Method {

    public Newton(float a, float b, double e) {
        super(a, b, e);
    };

    public  float newton() {
        float a = getA();
        float b = getB();
        double e = getE();
        float c = a - ((b - a) / (func(b) - func(a))) * func(a);
        while (Math.abs(func(c)) > e) {
            c = a - ((b - a) / (func(b) - func(a))) * func(a);
            b = c;
        }
        return c;
    }
}
