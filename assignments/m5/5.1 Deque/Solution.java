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
    void pushLeft(final String value) {
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
    void pushRight(final String value) {
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
    void popLeft() {
        if (first != null) {
            Node popped = first;
            first = first.next;
            popped.data = null;
            popped.next = null;
            noOfElements--;
        }
    }
    /**
     * popright.
     */
    void popRight() {
        if (last != null) {
            Node temp = null;
            Node popped = last;
            Node element = first;
            while (element != last) {
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
            while (temp != null) {
                str += temp.data + ", ";
                temp = temp.next;
            }
            return "[" + str.substring(0, str.length() - 2) + "]";
        }
        return "[]";

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
        Deque d = new Deque();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
            case "pushLeft":
                d.pushLeft(input[1]);
                System.out.println(d.print());
                break;
            case "pushRight":
                d.pushRight(input[1]);
                System.out.println(d.print());
                break;
            case "popLeft":
                if (!d.isEmpty()) {
                    d.popLeft();
                    System.out.println(d.print());
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "popRight":
                if (!d.isEmpty()) {
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
