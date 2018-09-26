import java.util.Scanner;
import java.util.Arrays;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int res = 1;
        int total = 0;
        int n = sc.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);

        for (int i = 0; i < n - 1; i++) {
            if (array[i] == array[i + 1]) {
                count += res;
                total += count;
                res++;
            } else {
                res = 1;
            }

        }
        System.out.println(count);
    }
}