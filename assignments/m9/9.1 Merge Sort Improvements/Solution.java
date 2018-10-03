import java.util.Scanner;
/**
 * Class for merge sort.
 */
class Mergesort {
    /**
     * cutoff to insertion sort.
     */
    private final int cutoff = 7;
    /**
     * Constructs the object.
     * .
     */
    Mergesort() {
        //Unused Constructor.
    }
    /**
     * Method to merge two arrays.
     * Time complexity of this method is O(N).
     * @param      array  The array
     * @param      aux    The auxiliary
     * @param      low    start
     * @param      mid    The middle value
     * @param      high    high
     */
    public void merge(final Comparable[] array, final Comparable[] aux,
                      final int low, final int mid, final int high) {
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > high) {
                aux[k] = array[i++];
            } else if (less(array[j], array[i])) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
    }
    /**
     * sorts.
     * Best case: O(log N)
     * Average case : O(logN)
     * worst case :O(log N)
     *
     * @param      array  The array
     * @param      aux    The auxiliary array
     * @param      low     The lower value
     * @param      high     The higher value
     */
    public void sort(final Comparable[] array, final Comparable[] aux,
                     final int low, final int high) {
        if (high <= low + cutoff) {
            insertionSort(aux, low, high);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = low + (high - low) / 2;
        sort(aux, array, low, mid);
        sort(aux, array, mid + 1, high);
        if (!less(array[mid + 1], array[mid])) {
            for (int i = low; i <= high; i++) {
                aux[i] = array[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(array, aux, low, mid, high);
    }
    /**
     * Rearranges the array in ascending order.
     *
     * Best case: O(1)
     * Average case : O(1)
     * worst case :O(1)
     *
     * @param      array     {Comparable array}.
     */
    public void sort(final Comparable[] array) {
        Comparable[] aux = array.clone();
        sort(aux, array, 0, array.length - 1);
    }
    /**
     * insertion sorting method.
     *
     * Best case: O(N)
     * Average case : O(N^2/2)
     * worst case :O(N^2)
     *
     * @param      array     array.
     * @param      low    start
     * @param      high    high
     */
    public void insertionSort(final Comparable[] array,
                              final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(array[j], array[j - 1]); j--) {
                swap(array, j, j - 1);
            }
        }
    }
    /**
     * swaps the value.
     *
     * Best case: O(1)
     * Average case : O(1)
     * worst case :O(1)
     *
     * @param      array   list
     * @param      i     {Integer i}
     * @param      j     {Integer j}
     */
    public void swap(final Comparable[] array,
                     final int i, final int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * checks if a is less than b or not.
     *
     * Best case: O(1)
     * Average case : O(1)
     * worst case :O(1)
     *
     * @param      a     {Comparable}.
     * @param      b     {Comparable}.
     *
     * @return     {Boolean value}.
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * the array is sorted (or) not.
     *
     * Best case: O(1)
     * Average case : O(1)
     * worst case :O(1)
     *
     * @param      array     list
     *
     * @return     boolean.
     */
    public boolean isSorted(final Comparable[] array) {
        return isSorted(array, 0, array.length - 1);
    }
    /**
     * array sorted or not.
     *
     * Best case: O(1)
     * Average case : O(n)
     * worst case :O(N).
     *
     * @param      array    list
     * @param      low    The start
     * @param      high    The end
     *
     * @return     boolean.
     */
    public boolean isSorted(final Comparable[] array,
                            final int low, final int high) {
        for (int i = low + 1; i <= high; i++) {
            if (less(array[i], array[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * prints the elements in the array.
     *
     * Best case: O(n)
     * Worst case: O(n)
     * Average case: O(n)
     *
     * @param      array   The arr
     *
     * @return     string
     */
    public String print(final Comparable[] array) {
        String str = "";
        for (int i = 0; i < array.length - 1; i++) {
            str += array[i] + ", ";
        }
        str += array[array.length - 1];
        return "[" + str + "]";
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     *
     */
    private Solution() {
        //Unused Constructor.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Mergesort m = new Mergesort();
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(",");
            m.sort(input);
            System.out.println(m.print(input));
            System.out.println();
        }
    }
}
