import java.util.Scanner;
/**
 * Class for symbol table.
 */
class SymbolTable {
	/**
	 * keys array.
	 */
	private String[] keys;
	/**
	 * values array.
	 */
	private Integer[] values;
	/**
	 * no of elemnts inserted till.
	 */
	private int size;
	/**
	 * Constructs the object.
	 *
	 * @param      n     { parameter_description }
	 */
	SymbolTable(final int n) {
		keys = new String[n];
		values = new Integer[n];
		size = 0;
	}
	/**
	 * inserts a key-value pair.
	 *
	 * @param      key    The key
	 * @param      value  The value
	 */
	void put(String key, Integer value){
		int i = rank(key);
		if(i < size && keys[i].compareTo(key) == 0) {
			values[i] = value;
			return;
		}
		for(int j = size; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = key;
		values[i] = value;
		size++;
	}
	/**
	 * contains.
	 *
	 * @param      key   The key
	 *
	 * @return     { description_of_the_return_value }
	 */
	boolean contains(String key) {
		return get(key) != null;
	}
	/**
	 * gets function.
	 *
	 * @param      key   The key
	 *
	 * @return     { description_of_the_return_value }
	 */
	Integer get(String key) {
		if (size == 0) {
			return null;
		}
		int i = rank(key);
		if(i < size && keys[i].compareTo(key) == 0) {
			return values[i];
		}
		return null;
	}
	/**
	 * rank.
	 *
	 * @param      key   The key
	 *
	 * @return     { description_of_the_return_value }
	 */
	int rank(String key) {
		int low = 0, high = size - 1;
		while(low <= high) {
			int mid = low + (high - low) / 2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0) {
				high = mid - 1;
			} else if(cmp > 0) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return low;
	}
	/**
	 * max.
	 *
	 * @return     { description_of_the_return_value }
	 */
	String max() {
		return keys[size - 1];
	}
	/**
	 * deletes min value.
	 */
	void deleteMin() {
		values[0] = null;
	}
	/**
	 * prints all values.
	 */
	void keys() {
		for(int i = 0; i < size; i++) {
			if(values[i] != null) {
				System.out.println(keys[i] + " " + values[i]);
			}
		}
	}
	String floor(String key) {
		int i = rank(key);
		if(i < size && key.compareTo(keys[i]) == 0) {
			return keys[i];
		}
		if(i == 0) {
			return null;
		}
		return keys[i - 1];
	}
}
/**
 * class for Solution.
 */
final class Solution {
	/**
	 * main.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		SymbolTable st = new SymbolTable(input.length);
		for(int i = 0; i < input.length; i++) {
			st.put(input[i], i);
		}
		while(sc.hasNextLine()) {
			String[] operation = sc.nextLine().split(" ");
			switch (operation[0]) {
				case "contains":
					System.out.println(st.contains(operation[1]));
					break;
				case "get":
					System.out.println(st.get(operation[1]));
					break;
				case "max":
					System.out.println(st.max());
					break;
				case "floor":
					System.out.println(st.floor(operation[1]));
					break;
				case "rank":
					System.out.println(st.rank(operation[1]));
					break;
				case "deleteMin":
					st.deleteMin();
					break;
				case "keys":
					st.keys();
					break;
				default:
					break;
			}
		}
	}
}