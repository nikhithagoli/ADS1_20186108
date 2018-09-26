import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //constructor.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int count = 0;
        /*for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    if(a[i]+a[j]+a[k] == 0){
                        count ++;
                    }
                }
            }
        }*/
        int j, k;
        Arrays.sort(a);
        //System.out.println(Arrays.toString(a));
        for (int i = 0; i < n - 2; i++) {
            j = i + 1;
            k = n - 1;
            //System.out.println(j+ "           " + k);
            while (j < k) {
                if (a[i] + a[j] + a[k] == 0) {
                    count++;
                    j++;
                    k--;
                } else if (a[i] + a[j] + a[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        System.out.println(count);
    }
}
