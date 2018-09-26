import java.util.Scanner;
import java.util.Arrays;
public class Solution{
	/*static int binarysearch(int[] arr, int first, int last, int search){
		if(first<last){
			int middle = (first + last)/2;
			if(arr[middle] == search){
				int k = middle;
				while(arr[k] == arr[k-1]){
					k--;
				}
				return k;
			}
			else if(search < arr[middle]){
				return binarysearch(arr, first, middle-1, search);
			}
			else{
				return binarysearch(arr, middle + 1, last, search);
			}
		}
		return -1;
	}*/
	static int binarysearch(int[] arr, int first, int last, int search){
		while(first < last){
			int middle = (first + last)/2;
			if(arr[middle] == search){
				if(arr[middle] == search){
					if ((middle > 0 && arr[middle] != arr[middle - 1]) || middle == 0){
						return middle;
					}
				}
			}
			else if(search < arr[middle]){
				last = middle - 1;
			}
			else{
				first = middle+1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i = 0; i < n; i++){
			array[i] = sc.nextInt();
		}
		Arrays.sort(array);
		int search = sc.nextInt();
		System.out.println(binarysearch(array, 0, n, search));
		
	}
}