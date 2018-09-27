import java.util.Scanner;
class LinkedList{
	Node head;
	private class Node{
		private char data;
		private Node next;
	} 
	void insert(char item){
		if(head == null){
			head = new Node();
			head.data = item;
			head.next = null;
		
		} else {
			Node newnode = new Node();
			newnode.data = item;
			newnode.next = head;
			head = newnode;
		}
	}
	char remove(){
		char popped = '\0';
		if(head != null){
			Node temp = head.next;
			head.next = null;
			popped = head.data;
			head = temp;
		}
		return popped;
	}
	char gettop(){
		return this.head.data;
	}
}
class Solution1{
	public String isBalanced(final String str) {
		LinkedList linked = new LinkedList();
        for (char each : str.toCharArray()) {
            if (each == '{' || each == '[' || each == '(') {
                linked.insert(each);
            } else {
                if (linked.head != null) {
                    char top = linked.gettop();
                    if ((top == '(' && each == ')') || (top == '{'
                     && each == '}') || (top == '[' && each == ']')) {
                        char poppeditem = linked.remove();
                    } else {
                        return "NO";
                    }
                } else {
                    return "NO";
                }
            }
        }
        if (linked.head == null) {
            return "YES";
        }
        return "NO";
	}
	public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution s = new Solution();
        int noOfInputs = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < noOfInputs; i++) {
            String input  = sc.nextLine();
            System.out.println(s.isBalanced(input));
        }
    }
}