import java.util.Scanner;
class Josephus{
	/**
     * no of elements.
     */
    private int noOfElements;
    /**
     * first, last nodes.
     */
    private Node first, last, temp2;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * data.
         */
        private int data;
        /**
         * next link.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      val   The value
         * @param      link  The link
         */
        Node(final int val, final Node link) {
            this.data = val;
            this.next = link;
        }
    }
    /**
     * Constructs the object.
     */
    Josephus() {
        noOfElements = 0;
        first = null;
        last = null;
    }

   	void insert(int val){
   		if(first == null){
   			first = new Node(val, first);
   			first.next = first;
   			last = first;
   			temp2 = first;
   		} else{
   			Node newnode = new Node(val, null);
   			last.next = newnode;
   			newnode.next = first;
   			last = newnode;
   		}
   		noOfElements++;
   	}
   	void print(){
   		Node temp = first;
   		while(temp.next != first){
   			System.out.println(temp.data);
   			temp = temp.next;
   		}
   	}
   	// private pivot;
   	int remove(int position){
   		Node temp = temp2, prev= null;
   		// System.out.println(temp.next.data);
   		for(int i = 0; i < position-1; i++){
   			prev = temp;
   			// System.out.println(temp.data + " "+ temp.next.data);
   			temp = temp.next;

   		}
   		prev.next = temp.next;
   		//temp.next = temp.next.next;
   		temp2 = temp.next;
   		noOfElements--;
   		return temp.data;

   	}
   	int size(){
   		return noOfElements;
   	}
}
class Solution1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int noOfinputs = sc.nextInt();
		Josephus obj = new Josephus();
		for(int i = 0; i < noOfinputs; i++){
			sc.nextLine();
			int n = sc.nextInt();
			int m = sc.nextInt();
			for(int j = 0; j < n; j++){
				obj.insert(j);
			}
			while(obj.size()!=0){
				System.out.println(obj.remove(m));
			}

		}
	}
}