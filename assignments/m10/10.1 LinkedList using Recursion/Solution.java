import java.util.Scanner;
class Node {
    String data;
    Node next;
    Node(String value, Node link) {
        this.data = value;
        this.next = link;
    }
}
class Linkedlist {
    private int noOfElements;
    private Node head, last, temp;
    Linkedlist() {
        noOfElements = 0;
        head = null;
    }
    /*Node insertAt(int position, String value){
        if(position == 0){
            return head;
        } else if(position == 1){
            return head;
        }
        return insertAt(position-1, value);
    }
    void insertAfter(Node newnode, String value){
        Node temp = new Node();
        if(newnode == null){
            temp.data= value;
            temp.next = newnode;
            head = temp;
        }else{
            temp.next = newnode.next;
            temp.data= value;
            newnode.next = temp;
        }

    }*/
    void insertAt(int position, String value)throws Exception {
        if (position < 0 || position > noOfElements) {
            throw new Exception();
        }
        temp = new Node(value, null);
        head = insertAfter(position, head, temp, 0);
    }
    Node insertAfter(int position, Node first, Node temp, int count) throws Exception {
        if (position == count) {
            temp.next = first;
            noOfElements++;
            return temp;
        }
        first.next = insertAfter(position, first.next, temp, count++);
        return first;
    }
    void reverse() {
        reverse(null, head);
    }
    void reverse(Node prev, Node curr) {
        if (curr != null) {
            reverse(curr, curr.next);
            curr.next = prev;
        } else {
            head = prev;
        }
    }
    String print() {
        Node temp = head;
        String str = "";
        while (temp != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }
        return str.substring(0, str.length() - 2);

    }
}
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Linkedlist linkedlist = new Linkedlist();
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(" ");
            switch (tokens[0]) {
            case "insertAt":
                try {
                    linkedlist.insertAt(Integer.parseInt(tokens[1]), tokens[2]);
                    System.out.println(linkedlist.print());
                } catch (Exception e) {
                    System.out.println("Can't insert at this position.");
                }

                break;
            case "reverse":
                try {
                    linkedlist.reverse();
                    System.out.println(linkedlist.print());
                } catch (Exception e) {
                    System.out.println("No elements to reverse.");
                }
                break;
            }
        }
    }
}





