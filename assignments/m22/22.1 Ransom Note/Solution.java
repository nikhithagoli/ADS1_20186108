import java.util.Scanner;
import java.util.Arrays;
class HashTable {
	class Node {
		private String key;
		private Integer val;
		private Node next;
		Node(String k, Integer v, Node n) {
			this.key = k;
			this.val = v;
			this.next = n;
		}
		String getkey() {
			return this.key;
		}
		Integer getValue() {
			return this.val;
		}
		void setvalue(Integer v) {
			this.val = v ;
		} 
	}
	private Node[] st;
	private int s = 97;
	HashTable() {
		st = new Node[s];
	}
	
	int hash(String k) {
		return (k.hashCode() & 0x7fffffff) % s;
	}
	public void resize() {
        st = Arrays.copyOf(st, 2 * s);
    }
	public void put(String k, Integer v) {
		int i = hash(k);
		for(Node x =st[i]; x!= null; x = x.next) {
			if(k.equals(x.getkey())) {
				x.setvalue(x.getValue() + 1);
				return;
			}
		}
		if(i >= st.length) {
			resize();
		}
		st[i] = new Node(k, v, st[i]);
	}

	public boolean get(String k) {
		int i = hash(k);
		for(Node x =st[i]; x!= null; x = x.next) {
			if(k.equals(x.getkey())) {
				if (x.getValue() > 0) {
					x.setvalue(x.getValue() - 1);
					return true;
				}
				return false;				
			}
		}
		return false;
	}
}
final class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		String[] magazine = sc.nextLine().split(" ");
		String[] note = sc.nextLine().split(" ");
		HashTable h = new HashTable();
		for(int i = 0; i < m; i++) {
			h.put(magazine[i], 1);
		}
		boolean flag = true;
		for(int i = 0; i < n; i++) {
			if(!h.get(note[i])) {
				flag = false;
				System.out.println("No");
				break;
			}
		}
		if(flag) {
			System.out.println("Yes");
		}
	}
}