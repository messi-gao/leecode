package sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {8, 4, 5, 7, 1, 3, 6, 2};
        new QuickSort().quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

    public void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int quivor = arr[(l + r) / 2];
        int tmp;
        while (l < r) {
            if (arr[l] < quivor) {
                l++;
            }
            if (arr[r] > quivor) {
                r--;
            }
            if (l >= r) {
                break;
            }
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }

        if (arr[l] == quivor) {
            r--;
        }

        if (arr[r] == quivor) {
            l++;
        }

        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }

        if (right < l) {
            quickSort(arr, l, right);
        }

    }

}
