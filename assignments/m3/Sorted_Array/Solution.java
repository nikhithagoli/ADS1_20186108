import java.util.Scanner;
public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] first = new int[m];
		int[] second = new int[n];
		/*int k = 0;
		for(String each : sc.nextLine().split(",")){
			first[k++] = Integer.parseInt(each);
		}
		k = 0;
		for(String each : sc.nextLine().split(",")){
			second[k++] = Integer.parseInt(each);
		}*/
		for(int k = 0; k < m; k++){
			first[k] = sc.nextInt();
		}
		for(int k = 0; k < m; k++){
			second[k] = sc.nextInt();
		}
		int[] result = new int[m+n];
		for(int i = 0, j = 0; i < m || j < n; i++,j++){
			result[i] = first[i];
			result[i+m] = second[j];
		}
		for(int i = 0; i<m+n; i++){
			System.out.print(result[i] + ",");
		}	
	}
}