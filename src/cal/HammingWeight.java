package cal;

public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & n - 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HammingWeight().hammingWeight(22));
    }
}
