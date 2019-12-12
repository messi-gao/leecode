package sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {8, 4, 5, 7, 1, 3, 6, 2};

        int left = 0;
        int right = array.length - 1;
        int[] tmp = new int[array.length];
        new MergeSort().mergeSort(array, left, right, tmp);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid + 1, right, temp);
            merge(arr, left, right, mid, temp);
        }
    }

    public void merge(int[] array, int left, int right, int mid, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                tmp[t] = array[i];
                i++;
                t++;
            } else {
                tmp[t] = array[j];
                j++;
                t++;
            }
        }

        while (i <= mid) {
            tmp[t] = array[i];
            i++;
            t++;
        }

        while (j <= right) {
            tmp[t] = array[j];
            j++;
            t++;
        }

        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            array[tempLeft] = tmp[t];
            t++;
            tempLeft++;
        }
    }
}
