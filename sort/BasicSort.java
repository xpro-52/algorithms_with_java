package sort;

public class BasicSort {

    public static void bubbleSort(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = x.length - 1; j > i; j--) {
                if (x[j - 1] > x[j]) {
                    swap(x, j - 1, j);
                }
            }
        }
    }

    public static void selectionSort(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            int min = i;
            for (int j = x.length - 1; j > i ; j--) {
                if (x[j] < x[min]) {
                    min = j;
                }
            }
            swap(x, i, min);
        }
    }

    public static void insertionSort(int[] x) {
        for (int i = 1; i < x.length; i++) {
            int p = i;
            while (p > 0 && x[p - 1] > x[p]) {
                swap(x, p - 1, p);
                p--;
            }
        }
    }

    static void swap(int[] x, int a, int b) {
        int tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;
    }
}
