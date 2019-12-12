package recursion;

class MyPow {
    public double help(double x, long n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            double v = help(x, n / 2);
            return v * v;
        }
        double v = help(x, n / 2);
        return x * v * v;
    }

    public double myPow(double x, int k) {
        if (k < 0) {
            k = -k;
            x = 1 / x;
        }
        return help(x, k);
    }

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2, -3));
    }

}
