package half;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {7, 1, 3, 5, 13, 9, 3, 6, 11};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        int l = left;
        int r = right;
        int base = array[left];

        while (l != r) {
            while (array[r] >= base && l < r) {
                r--;
            }
            while (array[l] <= base && l < r) {
                l++;
            }
            if (l < r) {
                int tmp = array[l];
                array[l] = array[r];
                array[r] = tmp;
            }
        }

        array[left] = array[l];
        array[l] = base;

        quickSort(array, left, l - 1);
        quickSort(array, l + 1, right);
    }
}
