package sort;

public class Sort {
    
    public static void mergeSort(int[] x) {
        mergeSort(x, 0, x.length - 1);
    }

    private static void mergeSort(int[] x, int first, int last) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(x, first, mid);
            mergeSort(x, mid + 1, last);
            merge(x, first, mid, last);
        }
    }

    private static void merge(int[] x, int first, int mid, int last) {
        int i = first, j = mid + 1 , k = 0;
        int[] tmp = new int[last - first + 1];
        while (i <= mid && j <= last) {
            if (x[i] < x[j]) {
                tmp[k++] = x[i++];
            } else {
                tmp[k++] = x[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = x[i++];
        }

        while (j <= last) {
            tmp[k++] = x[j++];
        }

        for (i = first; i <= last; i++) {
            x[i] = tmp[i - first];
        }
    }
}
