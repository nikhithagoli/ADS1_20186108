import java.util.Scanner;
import java.util.Arrays;
class Heapsort {
	private int[] array;
	private int size;
	Heapsort(int n){
		array = new int[n];
		size = 0;
	}
	void sort(){
		for(int i = ((size-1)/2)-1; i>=0; i--){
			heapify(size, i);
		}
		for(int i = size-1; i>=0; i--){
			swap(0, i);
			heapify(i, 0);
		}
	}
	void insert(int item){
		array[size++] = item;
		sort();
		//System.out.println(Arrays.toString(array));
	}
	void swap(int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	void heapify(int n, int i){
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;
		if(l<n && array[l] > array[largest]){
			largest = l;
		}
		if (r < n && array[r] > array[largest]){
			largest = r;
		}
		if(largest != i){
			swap(i, largest);
			heapify(n, largest);
		}
	}

	int getitem(int index){
		return array[index];
	}
	int getsize(){
		return size;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Heapsort heap =  new Heapsort(n);
		for(int i = 0; i < n; i++){
			heap.insert(Integer.parseInt(sc.nextLine()));
			int size = heap.getsize();
			//System.out.println(size);
			if((size) % 2 == 0){
				System.out.println(((float)heap.getitem((size - 1)/2) + (float)heap.getitem(size/2))/2.0);
				float median = ((float)heap.getitem((size - 1)/2) + (float)heap.getitem(size/2))/2;
				System.out.println(median);
			} else {
				float median = (float)heap.getitem((size-1)/2);
				System.out.println(median);
			}
		}
	}
}