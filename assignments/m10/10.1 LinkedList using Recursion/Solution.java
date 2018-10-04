import java.util.Scanner;
/**
 * Class for linkedlist.
 */
class Linkedlist {
    /**
     * linkedlist size.
     */
    private int noOfElements;
    /**
     * nodes.
     */
    private Node head, last, temp;
    /**
     * Class for node.
    */
    class Node {
        /**
        * node data.
        */
        private String data;
        /**
        * next node link.
        */
        private Node next;
        /**
         * node constructor.
         *
         * @param      value  The value
         * @param      link   The link
         */
        Node(final String value, final Node link) {
            this.data = value;
            this.next = link;
        }
    }
    /**
     * Constructs the object.
     */
    Linkedlist() {
        noOfElements = 0;
        head = null;
    }
    /**
     * insert at a position.
     *
     * @param      position   The position
     * @param      value      The value
     *
     * @throws     Exception  { exception_description }
     */
    void insertAt(final int position, final String value)throws Exception {
        if (position < 0 || position > noOfElements) {
            throw new Exception();
        }
        temp = new Node(value, null);
        head = insertAfter(position, head, temp, 0);
    }
    /**
     * inserts after a node at a given position.
     *
     * @param      position   The position
     * @param      first      The first
     * @param      temp1       The temporary
     * @param      count      The count
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     Exception  { exception_description }
     */
    Node insertAfter(final int position, final Node first,
     final Node temp1, final int count) throws Exception {
        temp = temp1;
        if (position == count) {
            temp.next = first;
            noOfElements++;
            return temp;
        }
        first.next = insertAfter(position, first.next, temp, count + 1);
        return first;
    }
    /**
     * to reverse a linked list.
     */
    void reverse() {
        reverse(null, head);
    }
    /**
     * revers the linkelist.
     *
     * @param      prev  The previous
     * @param      curr  The curr
     */
    void reverse(final Node prev, final Node curr) {
        if (curr != null) {
            reverse(curr, curr.next);
            curr.next = prev;
        } else {
            head = prev;
        }
    }
    /**
     * prints the linkedlist.
     *
     * @return     { description_of_the_return_value }
     */
    String print() {
        temp = head;
        String str = "";
        while (temp != null) {
            str += temp.data + ", ";
            temp = temp.next;
        }
        return str.substring(0, str.length() - 2);

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
        //constructor.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
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
            default:
                break;
            }
        }
    }
}
