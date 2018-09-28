import java.util.Scanner;
class Deque {
	int noOfElements;
	Node first, last;
	private class Node{
		String data;
		Node next;
		Node(String val, Node link){
			this.data = val;
			this.next = link;
		}
	}
	Deque(){
		noOfElements = 0;
		first = null;
		last = null;
	}
	void pushLeft(String value){
		if(first == null){
			first = new Node(value, null);
			//first.data = value;
			//first.next = null;
			last = first;
		} else{
			Node newnode = new Node(value, first);
		 	// newnode.data = value;
		 	// newnode.next = first;
		 	first = newnode;
		}
		 
		 noOfElements++;
	}
	void pushRight(String value){
		if(last == null){
			last = new Node(value, null);
			// last.data = value;
			// last.next = null;
			first = last; 
		}
		else{
			Node newnode = new Node(value, null);
			// newnode.data = value;
		    // newnode.next = null;
		 	last.next = newnode;
		 	last = newnode;
		}
		noOfElements++;
	}

	void popLeft(){
		if(first != null){
			Node popped = first;
			first = first.next;
			popped.data = null;
			popped.next = null;
			noOfElements--;
		}
	}

	void popRight(){
		if(last != null){
			Node temp = null;
			Node popped = last;
			Node element = first; 
			while(element != last){
				temp = element;
				element = element.next;
			}
			last = temp;
			last.next = null;
			popped.data = null;
			popped.next = null;
			noOfElements--;
		}
	}
	int size(){
		return noOfElements;
	}

	boolean isEmpty(){
		return first == null;
	}

	String print(){
		if(noOfElements != 0){
			String str = "";
			Node temp = first;
			while(temp != null){
				str += temp.data + ", ";
				temp = temp.next;
			}
			return "[" + str.substring(0,str.length()-2) + "]";
		}
		return "[]";
		
	}

}
class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Deque d = new Deque();
		for(int i = 0; i < n; i++){
			String[] input = sc.nextLine().split(" ");
			switch(input[0]){
				case "pushLeft":
					d.pushLeft(input[1]);
					System.out.println(d.print());
					break;
				case "pushRight":
					d.pushRight(input[1]);
					System.out.println(d.print());
					break;
				case "popLeft":
					if(!d.isEmpty()){
						d.popLeft();
						System.out.println(d.print());
					} else{
						System.out.println("Deck is empty");
					}
					break;
				case "popRight":
					if(!d.isEmpty()){
						d.popRight();
						System.out.println(d.print());
					} else {
						System.out.println("Deck is empty");
					}
					break;
				case "size":
					System.out.println(d.size());
					break;
				case "isEmpty":
					System.out.println(d.isEmpty());
					break;
				default:
					break;

			}
		}
	}
}