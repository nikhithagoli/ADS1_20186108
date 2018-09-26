import java.util.Scanner;
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
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        int[] first = new int[m];
        int[] second = new int[n];
        int k = 0, i = 0, j = 0;
        String str = "";
        String[] s;
        if (m != 0) {
            s = sc.nextLine().split(",");
            for (String each : s) {
                first[k++] = Integer.parseInt(each);
            }
        } else {
            sc.nextLine();
        }
        k = 0;
        if (n != 0) {
            s = sc.nextLine().split(",");
            for (String each : s) {
                second[k++] = Integer.parseInt(each);
            }
        } else {
            sc.nextLine();
        }
        while (i < m && j < n) {
            if (first[i] < second[j]) {
                str += Integer.toString(first[i++]) + ",";
            } else if (first[i] > second[j]) {
                str += Integer.toString(second[j++]) + ",";
            } else {
                str += Integer.toString(second[j++]) + ",";
                i++;
            }
        }
        while (i < m) {
            str += Integer.toString(first[i++]) + ",";
        }
        while (j < n) {
            str += Integer.toString(second[j++]) + ",";
        }
        System.out.println(str.substring(0, str.length() - 1));
    }
}
