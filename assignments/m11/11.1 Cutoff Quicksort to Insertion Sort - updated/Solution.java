import java.util.Scanner;
import java.util.Arrays;
class Quicksort{
	/**
     * cutoff to insertion sort.
     */
    private int cutoff;
    /**
     * Constructs the object.
     * .
     */
    Quicksort() {
        //Unused Constructor.
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
     * rearranges the array.
     * 
     * Best case: O(1)
     * Average case : O(1)
     * worst case :O(1)
     * 
     * @param      array  The array
     * @param      m      { parameter_description }
     */
    public void sort(final Comparable[] array, int m){
    	cutoff = m;
    	sort(array, 0, array.length-1);
    	System.out.println(Arrays.toString(array));
    }
    /**
     * rearranges the subarrays.
     * Best case: O(NlogN)
     * Average case : O(NlogN)
     * worst case :O(N^2)
     * 
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     */
    public void sort(final Comparable[] array, int low, int high){
    	//System.out.println(low + "			" + high );	
    	if (high <= low + cutoff - 1) {
            insertionSort(array, low, high);
            System.out.println("insertionSort called");
            //System.out.println(Arrays.toString(array));
        } else{
        	int j = partition(array, low, high);
    		sort(array, low, j-1);
    		sort(array, j+1, high);
        }
    }
    /**
     * partition.
     * 
     * Best case: O(1)
     * Average case : O(1)
     * worst case :O(1)
     *
     * @param      array  The array
     * @param      low    The low
     * @param      high   The high
     *
     * @return     { description_of_the_return_value }
     */
    public int partition(final Comparable[] array, final int low, final int high){
    	int i = low, j = high + 1;
    	while(true){
    		while(less(array[++i], array[low])){
    			if(i == high){
    				break;
    			}
    		}
    		while(less(array[low], array[--j])){
    			if(j == low){
    				break;
    			}
    		}
    		if(i >= j){
    			break;
    		}
    		swap(array, i, j);
    	}
    	swap(array, low, j);
    	System.out.println(Arrays.toString(array));
    	return j;
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
     	Quicksort quick = new Quicksort();
     	int noOfInputs = sc.nextInt();
     	sc.nextLine();
        for(int i = 0; i < noOfInputs; i++){
        	int m = sc.nextInt();
        	sc.nextLine();
            String[] input = sc.nextLine().split(" ");
            quick.sort(input, m);
        }
    }
}