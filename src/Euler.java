package src;

import java.util.ArrayList;
public class Euler {

    private double h = 0.2;
    private ArrayList<Double> x0 = new ArrayList<>();
    private ArrayList<Double> y = new ArrayList<>();
    private int n = (int) ((2 - 0) / h);

    private double f(double y) {
        return -y;
    }
    private double g(double x){
        return Math.pow(Math.E, -x);
    }
    public void euler() {
        x0.add(0.0);
        y.add(1.0);
        for (int i = 0; i <= n; i++) {
            x0.add(x0.get(i) + h * i);
            y.add(y.get(i) + h * f(y.get(i)));
        }
        for (int i = 0; i < y.toArray().length; i++) {
            System.out.println("x0 = " + x0.get(i) + "\ny = " + y.get(i));
        }
    }
}
