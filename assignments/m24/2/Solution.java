import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for book.
 */
class Student {
    /**
     * name.
     */
    private String name;
    /**
     * rollnumber.
     */
    private Integer rollnumber;
    /**
     * total.
     */
    private Double total;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     * @param      a     { parameter_description }
     * @param      p     { parameter_description }
     */
    Student(final Integer r, final String n, final Double t) {
        this.name = n;
        this.rollnumber = r;
        this.total = t;
    }
    /**
     * get name.
     *
     * @return     { description_of_the_return_value }
     */
    String getname() {
        return this.name;
    }
    /**
     * get rollnumber.
     *
     * @return     { description_of_the_return_value }
     */
    Integer getrollnumber() {
        return this.rollnumber;
    }
    /**
     * get total.
     *
     * @return     { description_of_the_return_value }
     */
    Double gettotal() {
        return this.total;
    }
    /**
     * compare.
     * best case: O(1)
     * worst case: O(1)
     * Average case: O(1)
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    int compareTo(final Student that) {
        if (this.total.compareTo(that.total) > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
/**
 * Class for binary search tree.
 */
class BinarySearchTree {
    /**
     * Class for node.
     */
    class Node {
        /**
         * key.
         */
        private Student key;
        /**
         * name.
         */
        private String value;
        /**
         * left.
         */
        private Node left;
        /**
         * right.
         */
        private Node right;
        /**
         * Constructs the object.
         *
         * @param      k     { parameter_description }
         * @param      v     { parameter_description }
         */
        Node(final Student k, final String v) {
            this.key = k;
            this.value = v;
            this.left = null;
            this.right = null;
        }
    }
    /**
     * root.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    BinarySearchTree() {
        root = null;
    }
    /**
     * put.
     *
     * @param      key    The key
     * @param      value  The value
     */
    public void put(final Student key, final String value) {
        root = put(root, key, value);
    }
    /**
     * put.
     * best case: log(N)
     * worst case: O(n)
     * Average case: logN
     * @param      x      { parameter_description }
     * @param      key    The key
     * @param      value  The value
     *
     * @return     { description_of_the_return_value }
     */
    private Node put(final Node x, final Student key, final String value) {
        if (x == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(x.key);
        if (cmp <= 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }
        return x;
    }
    void get(Node x, Double k1, Double k2) { 
        if (x == null) { 
            return; 
        } 
        if (k1 < x.key.gettotal()) { 
            get(x.left, k1, k2); 
        } 
  
        /* if root's data lies in range, then prints root's data */
        if (k1 <= x.key.gettotal() && k2 >= x.key.gettotal()) { 
            System.out.println(x.value + " "); 
        } 
  
        /* If root->data is smaller than k2, then only we can get o/p keys 
         in right subtree */
        if (k2 > x.key.gettotal()) { 
            get(x.right, k1, k2); 
        } 
    }
    void getbe(Double k1, Double k2) {
    	get(root, k1, k2);
    }
    void getle(Double k) {
    	get(root, 0.0, k);
    }
    /*void getle(Node x, Double k) { 
        if (x == null) { 
            return; 
        } 
        if (k < x.key.gettotal()) { 
            getle(x.left, k); 
        } 
  		System.out.println(x.value);
    }*/
    Double findMax(Node node) 
    { 
        if (node == null) 
            return 0.0; 
  
        Double res = node.key.gettotal(); 
        Double lres = findMax(node.left); 
        Double rres = findMax(node.right); 
  
        if (lres > res) 
            res = lres; 
        if (rres > res) 
            res = rres; 
        return res; 
    }
    void getge(Double k) {
    	get(root, k, findMax(root));
    }
    /* getge(Node x, Double k) { 
        if (x == null) { 
            return; 
        } 
        if (k > x.key.gettotal()) { 
            getge(x.right, k); 
        } 
  		System.out.println(x.value);
    }*/
}
/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//unsed.
	}
	/**
	 * main.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		BinarySearchTree bst = new BinarySearchTree();
		for(int i = 0; i < n; i++) {
			String[] input = sc.nextLine().split(",");
			bst.put(new Student(Integer.parseInt(input[0]), input[1], Double.parseDouble(input[2])), input[1]);
		}
		int m = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < m; i++) {
			String[] input = sc.nextLine().split(" ");
			if(input[0].equals("BE")) {
				bst.getbe(Double.parseDouble(input[1]), Double.parseDouble(input[2]));
			} else if(input[0].equals("LE")) {
				bst.getle(Double.parseDouble(input[1]));
			} else {
				bst.getge(Double.parseDouble(input[1]));
			}
			
		}
	}
}