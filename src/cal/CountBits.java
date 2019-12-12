package cal;

public class CountBits {
    public int[] countBits(int num) {
        int[] ints = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ints[i] = (ints[i & (i - 1)]) + 1;
        }
        return ints;
    }

    public static void main(String[] args) {
        int[] ints = new CountBits().countBits(5);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
