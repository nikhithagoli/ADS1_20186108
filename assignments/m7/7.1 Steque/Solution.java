import java.util.Scanner;
/**
 * Class for deque.
 */
class Deque {
    /**
     * no of elements.
     */
    private int noOfElements;
    /**
     * first, last nodes.
     */
    private Node first, last;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * data.
         */
        private String data;
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
        Node(final String val, final Node link) {
            this.data = val;
            this.next = link;
        }
    }
    /**
     * Constructs the object.
     */
    Deque() {
        noOfElements = 0;
        first = null;
        last = null;
    }
    /**
     * Pushes a left.
     *
     * @param      value  The value
     */
    void push(final String value) {
        if (first == null) {
            first = new Node(value, null);
            //first.data = value;
            //first.next = null;
            last = first;
        } else {
            Node newnode = new Node(value, first);
            // newnode.data = value;
            // newnode.next = first;
            first = newnode;
        }

        noOfElements++;
    }
    /**
     * Pushes a right.
     *
     * @param      value  The value
     */
    void enqueue(final String value) {
        if (last == null) {
            last = new Node(value, null);
            // last.data = value;
            // last.next = null;
            first = last;
        } else {
            Node newnode = new Node(value, null);
            // newnode.data = value;
            // newnode.next = null;
            last.next = newnode;
            last = newnode;
        }
        noOfElements++;
    }
    /**
     * popleft.
     */
    void pop() {
        if (first != null) {
            Node popped = first;
            first = first.next;
            popped.data = null;
            popped.next = null;
            noOfElements--;
        }
        if(first == null){
            last =null;
        }
    }
    void setsize(){
        this.noOfElements = 0;
    }

    /**
     * size.
     *
     * @return     { description_of_the_return_value }
     */
    int size() {
        return noOfElements;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return first == null;
    }
    /**
     * prints.
     *
     * @return     { description_of_the_return_value }
     */
    String print() {
        if (noOfElements != 0) {
            String str = "";
            Node temp = first;
            while (temp.next != null) {
                str += temp.data + ", ";
                temp = temp.next;
            }
            str += temp.data + ", ";
            return str.substring(0, str.length() - 2);
        }
        return "Steque is empty.";

    }

}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //function.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            Deque d = new Deque();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                //System.out.println(line);
                if(line == "\n" || line == "" || line == " "){
                    break;
                } else {
                    String[] input = line.split(" ");
                    switch (input[0]) {
                        case "push":
                            d.push(input[1]);
                            System.out.println(d.print());
                            break;
                        case "enqueue":
                            d.enqueue(input[1]);
                            System.out.println(d.print());
                            break;
                        case "pop":
                            if (!d.isEmpty()) {
                                d.pop();
                                System.out.println(d.print());
                            } else {
                                System.out.println("Steque is empty.");
                            }
                            break;
                        default:
                            break;

                    }
                }
                
            }
            System.out.println();
        }
    }
}
