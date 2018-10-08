import java.util.Scanner;

/**
 * Class for quicksort.
 */
class Quicksort {

    /**
     * Constructs the object.
     */
    protected Quicksort () {
        /**
         * empty.
         */
    }

    /**
     * sort function.
     *
     * @param      array      { parameter_description }
     * @param      pi  The pivot
     */
    public static void sort(final Comparable[] array, final int pi) {
        sort(array, 0, array.length - 1, pi);
        assert isSorted(array);
    }

    /**
     * sort function.
     *
     * @param      array      { parameter_description }
     * @param      low     The lower
     * @param      high     The higher
     * @param      pi  The pivot
     */
    private static void sort(
        final Comparable[] array, final int low, final int high, final int pi) {
        if (high <= low + pi - 1) {
            System.out.println("insertionSort called");
            insertionSort(array, low, high);
            return;
        }

        if (high <= low) {
            return;
        }
        int j = partition(array, low, high);
        sort(array, low, j - 1, pi);
        sort(array, j + 1, high, pi);
        assert isSorted(array, low, high);
    }
    /**
     * partition function.
     *
     * @param      array     { parameter_description }
     * @param      low    The lower
     * @param      high    The higher
     *
     * @return     { description_of_the_return_value }
     */
    private static int partition(
        final Comparable[] array, final int low, final int high) {
        int i = low;
        int j = high + 1;
        Comparable v = array[low];
        while (true) {

            // find item on lo to swap
            while (less(array[++i], v)) {
                if (i == high) {
                    break;
                }
            }

            // find item on hi to swap
            while (less(v, array[--j])) {
                if (j == low) {

                    break;
                }
            }


            // check if pointers cross
            if (i >= j) {
                break;
            }

            exch(array, i, j);
        }

        // put partitioning item v at a[j]
        exch(array, low, j);
        show(array);
        System.out.println();

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    /**.
     *
     * @param  array the array
     * @param  k the rank of the key
     * @return the key of rank {@code k}
     * @throws IllegalArgumentException unless {@code 0 <= k < a.length}
     */
    public static Comparable select(final Comparable[] array, final int k) {
        if (k < 0 || k >= array.length) {
            throw new IllegalArgumentException(
                "index is not between 0 and " + array.length + ": " + k);
        }
        // StdRandom.shuffle(a);
        int low = 0, high = array.length - 1;
        while (high > low) {

            int i = partition(array, low, high);
            if (i > k) {
                high = i - 1;
            } else if (i < k) {
                low = i + 1;
            } else {
                return array[i];
            }
        }
        return array[low];
    }



    /*********************************************************************
     *  Helper sorting functions.
     **********************************************************************/
    /**
     * less function.
     *
     * @param      v     { parameter_description }
     * @param      w     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private static boolean less(final Comparable v, final Comparable w) {
        if (v == w) {
            return false;   // optimization when reference equals

        }
        return v.compareTo(w) < 0;
    }

    /**
     * exchanges the elements.
     *
     * @param      a     { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private static void exch(final Object[] array, final int i, final int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /**
     * isorted function.
     *
     * @param      array     { parameter_description }
     *
     * @return     True if sorted, False otherwise.
     */
    private static boolean isSorted(final Comparable[] array) {
        return isSorted(array, 0, array.length - 1);
    }
    /**
     * Determines if sorted.
     *
     * @param      a     { parameter_description }
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     True if sorted, False otherwise.
     */
    private static boolean isSorted(
        final Comparable[] a, final int lo, final int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }



    /**
     * show the array.
     *
     * @param      a     { parameter_description }
     */
    public  static void show(final Comparable[] a) {
        String str = "[";
        for (int i = 0; i < a.length; i++) {
            str += a[i] + ", ";
        }
        System.out.print(str.substring(0, str.length() - 2) + "]");
    }
    /**
     * {Method for insertion sort}.
     * sort from a[lo] to a[hi].
     * Time complexity of insertion sort is O(N^2/2).
     * @param      a     {Comparable array}.
     * @param      lo    The lower value
     * @param      hi    The higher value
     */
    public static void insertionSort(final Comparable[] a,
                                     final int lo, final int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
                // show(a);
            }
        }
    }

}

/**
 * Class for solution.
 */
public final class Solution {
    /**
     * contructor.
     */
    private Solution() {

    }
    /**
     * main maethod starts here.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int noOfTestcases = input.nextInt();
        // System.out.println();
        for (int i = 0; i < noOfTestcases; i++) {
            int pivot = input.nextInt();
            input.nextLine();
            String elements = input.nextLine();
            Quick array = new Quick();
            String[] elearr = elements.split(" ");
            array.sort(elearr, pivot);
            // System.out.println(array.show(elearr));
            array.show(elearr);
            System.out.println();



        }
    }
}