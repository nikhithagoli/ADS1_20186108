import java.util.Scanner;
/**
* class for linked list.
*/
class LinkedList {
    /**
     * no of elements.
     */
    private int noOfElements;
    /**
     * Class for node.
     */
    class Node {
        /**
         * digit.
         */
        private String digit;
        /**
         * next.
         */
        private Node next;
        /**
         * { function_description }.
         *
         * @return     { description_of_the_return_value }
         */
        String getdigit() {
            return this.digit;
        }
        /**
         * { function_description }.
         *
         * @return     { description_of_the_return_value }
         */
        Node getnext() {
            return this.next;
        }
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
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    Node gethead(){
        return this.head;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    Node getlast(){
        return this.last;
    }
    
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    Node gettemp(){
        return this.temp;
    }
    

}
/**
 * Class for add large numbers.
 */
final class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    private AddLargeNumbers() {
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
            str += list.temp.getdigit();
            list.temp = list.temp.getnext();
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
            stack1.insertleft(list1.temp.getdigit());
            list1.temp = list1.temp.getnext();
        }
        //System.out.println(digitsToNumber(stack1));
        list2.temp = list2.head;
        while (list2.temp != null) {
            stack2.insertleft(list2.temp.getdigit());
            list2.temp = list2.temp.getnext();
        }
        //System.out.println(digitsToNumber(stack2));
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int a = Integer.parseInt(stack1.remove());
            int b = Integer.parseInt(stack2.remove());
            String[] res = Integer.toString(a + b + carry).split("");
            //System.out.println(Arrays.toString(res));
            if (res.length == 2) {
                added.insertleft(res[1]);
                carry = Integer.parseInt(res[0]);
            } else {
                added.insertleft(res[0]);
                carry = 0;
            }

        }
        if (stack1.isEmpty() && stack2.isEmpty()) {
            added.insertleft(Integer.toString(carry));
        } else {
            while (!stack1.isEmpty()) {
                int d = Integer.parseInt(stack1.remove()) + carry;
                carry = 0;
                added.insertleft(Integer.toString(d));
            }

            while (!stack2.isEmpty()) {
                int d = Integer.parseInt(stack2.remove()) + carry;
                carry = 0;
                added.insertleft(Integer.toString(d));
            }
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
            //System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            qDigits = AddLargeNumbers.numberToDigits(q);
            //System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits,
             qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default:
            break;
        }
    }

}
