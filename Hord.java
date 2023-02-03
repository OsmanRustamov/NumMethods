public class Hord extends Method {


    public Hord(float a, float b, double e) {
        super(a, b, e);
    };

    public  float hord() {
        float a = getA();
        float b = getB();
        double e = getE();
        float c = a - ((b - a) / (func(b) - func(a))) * func(a);
        while (Math.abs(func(c)) > e) {
            a = c;
            c = a - ((b - a) / (func(b) - func(a))) * func(a);
        }
        return c;
    }

}
