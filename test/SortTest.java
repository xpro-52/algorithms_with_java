package test;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

import sort.BasicSort;
import sort.Sort;

public class SortTest {
    @Test
    public void testBubbleSort() {
        int[] arr = createShuffledArr();
        BasicSort.bubbleSort(arr);
        checkASC(arr);
    }

    @Test
    public void testSelectionSort() {
        int[] arr = createShuffledArr();
        BasicSort.selectionSort(arr);
        checkASC(arr);
    }

    @Test
    public void testInsertionSort() {
        int[] arr = createShuffledArr();
        BasicSort.insertionSort(arr);
        checkASC(arr);
    }

    @Test
    public void testMergeSort() {
        int[] arr = createShuffledArr();
        Sort.mergeSort(arr);
        checkASC(arr);
    }

    static void checkASC(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue("failed: " + i + ", arr[i]=" + arr[i] + ", arr[i+1]=" + arr[i + 1], arr[i] < arr[i + 1]);
        }
    }

    static int[] createShuffledArr() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randi = rand.nextInt(100);
            int tmp = arr[i];
            arr[i] = arr[randi];
            arr[randi] = tmp;
        }
        return arr;
    }
}
