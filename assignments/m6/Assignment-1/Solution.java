import java.util.Scanner;
//import java.util.Arrays;
import java.util.Stack;

// class Stack {
//     /**
//      * stack list.
//      */
//     private String[] stack;
//     /**
//      * top index.
//      */
//     private int top;
//     /**
//      * Constructs the object.
//      *
//      * @param      n     { parameter_description }
//      */
//     Stack() {
//         stack = new String[10];
//         top = 0;
//     }
//     void resize(){
//      stack = Arrays.copyOf(stack, stack.length*2);
//     }
//     /**
//      * pushes.
//      *
//      * @param      item  The item
//      */
//     void push(final String item) {
//      if(top == stack.length){
//          resize();
//      }
//         stack[top++] = item;
//     }
//     /**
//      * pops.
//      *
//      * @return     { description_of_the_return_value }
//      */
//     String pop() {
//         String popped = stack[--top];
//         //stack[top--] = '\0';
//         return popped;
//     }
//     /**
//      * Determines if empty.
//      *
//      * @return     True if empty, False otherwise.
//      */
//     boolean isEmpty() {
//         return top == 0;
//     }
//     /**
//      * Determines if full.
//      *
//      * @return     True if full, False otherwise.
//      */
//     boolean isFull() {
//         return top == stack.length;
//     }
//     /**
//      * returns top element.
//      *
//      * @return     { description_of_the_return_value }
//      */
//     String gettop() {
//         return stack[top - 1];
//     }

// }
class LinkedList {
    class Node {
        String digit;
        Node next;
    }
    Node head, last, temp, newnode;
    LinkedList() {
        head = null;
        last = null;
    }

    void insert(String val) {
        if (head == null) {
            head = new Node();
            head.digit = val;
            head.next = null;
            last = head;
            temp = head;
        } else {
            newnode = new Node();
            newnode.digit = val;
            newnode.next = null;
            last.next = newnode;
            last = newnode;
            newnode = null;

        }
    }
    void insertleft(String val) {
        if (head == null) {
            head = new Node();
            head.digit = val;
            head.next = null;
        } else {
            newnode = new Node();
            newnode.digit = val;
            newnode.next = head;
            head = newnode;
            newnode = null;
        }
    }
}
class AddLargeNumbers {

    public static LinkedList numberToDigits(String number) {
        LinkedList l = new LinkedList();
        String[] digits = number.split("");
        for (String each : digits) {
            l.insert(each);
        }
        return l;
    }

    public static String digitsToNumber(LinkedList list) {
        String str = "";
        list.temp = list.head;
        while (list.temp != null) {
            str += list.temp.digit;
            list.temp = list.temp.next;
        }
        list.temp = null;
        return str;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        LinkedList added = new LinkedList();
        // Stack stack1 = new Stack();
        // Stack stack2 = new Stack();
        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        list1.temp = list1.head;
        while (list1.temp != null) {
            stack1.push(list1.temp.digit);
        }
        list1.temp = null;
        list2.temp = list2.head;
        while (list2.temp != null) {
            stack2.push(list2.temp.digit);
        }
        list2.temp = null;
        int carry = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int a = Integer.parseInt(stack1.pop());
            int b = Integer.parseInt(stack2.pop());
            String[] res = Integer.toString(a + b + carry).split("");
            if (res.length == 2) {
                added.insertleft(res[1]);
                carry = Integer.parseInt(res[0]);
            } else {
                added.insertleft(res[0]);
            }

        }
        while (!stack1.isEmpty()) {
            added.insertleft(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            added.insertleft(stack2.pop());
        }
        return added;
    }
}

public class Solution {
    public static void main(String[] args) {
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
        }
    }

}
