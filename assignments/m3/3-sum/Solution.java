import java.util.Scanner;
import java.util.Arrays;
public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++){
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
        for (int i = 0; i < n - 2; i++) {
            j = i + 1;
            k = n - 1;
            while (j < k) {
                if (a[i] + a[j] + a[k] == 0) {
                    count ++;
                }
                else if (a[i] + a[j] + a[k] < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
		System.out.println(count);
	}
}