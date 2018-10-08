import java.util.Scanner;
import java.lang.Comparable;
class Minheap<E> {
	private int i;
	private int j;
	private E[] array;
	private int size; 
	public Minheap(int n){
		array = ((E[])new Object[n]);
		size = 0;
	}
	 public void add(E item) {
        //Inserts the specified element at the end of the list.
        //You can modify the code in this method.
        array[(size++)] = item;
    }
	int less(){
		String temp1 = array[i].toString();
        String temp2 = array[j].toString();
        return temp1.compareTo(temp2);
		
	}
	public boolean swim(){
		for(int k = 0; k <size; k++){
			i = k;
			j = k/2;
			if(k>1 && less() <= 0){
				return false;
			}
		}
		return true;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String type = sc.nextLine();
		int nooftestcases = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < nooftestcases; i++){
			String[] input = sc.nextLine().split(",");
			switch(type){
				case "String":
					Minheap<String> stringheap = new Minheap(input.length);
					for(int j = 0; j < input.length; j++){
						stringheap.add(input[j]);
					}
					System.out.println(stringheap.swim());
					break;
				case "Integer":
					Minheap<Integer> intheap = new Minheap(input.length);
					for(int j = 0; j < input.length; j++){
						intheap.add(Integer.parseInt(input[j]));
					}
					System.out.println(intheap.swim());
					break;
				case "Float":
					Minheap<Float> floatheap = new Minheap(input.length);
					for(int j = 0; j < input.length; j++){
						floatheap.add(Float.parseFloat(input[j]));
					}
					System.out.println(floatheap.swim());
					break;
				case "Double":
					Minheap<Double> doubleheap = new Minheap(input.length);
					for(int j = 0; j < input.length; j++){
						doubleheap.add(Double.parseDouble(input[j]));
					}
					System.out.println(doubleheap.swim());
					break;
				
				
			}
		}
	}
}