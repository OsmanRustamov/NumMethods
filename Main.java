public class Main {
    public static void main(String[] args) {
        Dihotomy d = new Dihotomy(1, 2, 0.001);
        Newton n = new Newton(1, 2, 0.001);
        Iteration i = new Iteration(1, 2, 0.001);
        Hord h = new Hord(1, 2, 0.001);
        System.out.println(d.dihotomy());
        System.out.println(i.iteration());
        System.out.println(n.newton());
        System.out.println(h.hord());
    }
}