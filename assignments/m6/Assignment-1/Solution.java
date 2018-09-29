import java.util.Scanner;
import java.util.Stack;
/**
* class for linked list.
*/
class LinkedList {
    /**
     * Class for node.
     */
    int noOfElements;
    class Node {
        /**
         * digit.
         */
        String digit;
        /**
         * next.
         */
        Node next;
    }
    /**
     * nodes.
     */
    Node head, last, temp;
    /**
     * Constructs the object.
     */
    LinkedList() {
        head = null;
        last = null;
        noOfElements = 0;
    }
    /**
     * insert.
     *
     * @param      val   The value
     */
    void insert(final String val) {
        if (head == null) {
            head = new Node();
            head.digit = val;
            head.next = null;
            last = head;
        } else {
            temp = new Node();
            temp.digit = val;
            temp.next = null;
            last.next = temp;
            last = temp;

        }
    }
    /**
     * val.
     *
     * @param      val   The value
     */
    void insertleft(final String val) {
        if (head == null) {
            head = new Node();
            head.digit = val;
            head.next = null;
        } else {
            temp = new Node();
            temp.digit = val;
            temp.next = head;
            head = temp;
        }
        noOfElements++;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return noOfElements == 0;
    }
    /**
     * removes.
     *
     * @return     { description_of_the_return_value }
     */
    String remove() {
        String popped = head.digit;
        head = head.next;
        noOfElements--;
        return popped;
    }
}
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    private AddLargeNumbers(){
        //contructor.
    }
    /**
     * numbertodigits.
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList l = new LinkedList();
        String[] digits = number.split("");
        for (String each : digits) {
            l.insert(each);
        }
        return l;
    }
    /**
     * digits too number.
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(final LinkedList list) {
        String str = "";
        list.temp = list.head;
        while (list.temp != null) {
            str += list.temp.digit;
            list.temp = list.temp.next;
        }
        list.temp = null;
        return str;
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList addLargeNumbers(final LinkedList list1,
     final LinkedList list2) {
        LinkedList added = new LinkedList();
        LinkedList stack1 = new LinkedList();
        LinkedList stack2 = new LinkedList();
        list1.temp = list1.head;
        while (list1.temp != null) {
            stack1.insertleft(list1.temp.digit);
        }
        list2.temp = list2.head;
        while (list2.temp != null) {
            stack2.insertleft(list2.temp.digit);
        }
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int a = Integer.parseInt(stack1.remove());
            int b = Integer.parseInt(stack2.remove());
            String[] res = Integer.toString(a + b + carry).split("");
            if (res.length == 2) {
                added.insertleft(res[1]);
                carry = Integer.parseInt(res[0]);
            } else {
                added.insertleft(res[0]);
            }

        }
        while (!stack1.isEmpty()) {
            added.insertleft(stack1.remove());
        }
        while (!stack2.isEmpty()) {
            added.insertleft(stack2.remove());
        }
        return added;
    }
}
/**
 * class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution(){
        //function.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default:
            break;
        }
    }

}
