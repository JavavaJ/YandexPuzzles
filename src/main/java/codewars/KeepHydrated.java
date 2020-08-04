package codewars;

public class KeepHydrated {

    public int liters(double time)  {
        double litresInHour = 0.5;
        double liters = time * litresInHour;
        return (int) liters;
    }

    public static void main(String[] args) {
        KeepHydrated kh = new KeepHydrated();

        double result = kh.liters(3.0);
        System.out.println(result);

        System.out.println("3 is expected: " + kh.liters(6.7));
        System.out.println("5 is expected: " + kh.liters(11.8));
        System.out.println("0 is expected: " + kh.liters(0.97));
        System.out.println("7 is expected: " + kh.liters(14.64));
    }

}
