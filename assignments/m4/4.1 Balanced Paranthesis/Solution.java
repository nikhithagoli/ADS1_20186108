import java.util.Scanner;
/**
 * stack class .
 */
class Stack {
    /**
     * stack list.
     */
    private char[] stack;
    /**
     * top index.
     */
    private int top;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     */
    Stack(final int n) {
        stack = new char[n];
        top = 0;
    }
    /**
     * pushes.
     *
     * @param      item  The item
     */
    void push(final char item) {
        stack[top++] = item;
    }
    /**
     * pops.
     *
     * @return     { description_of_the_return_value }
     */
    char pop() {
        char popped = stack[--top];
        //stack[top--] = '\0';
        return popped;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return top == 0;
    }
    /**
     * Determines if full.
     *
     * @return     True if full, False otherwise.
     */
    boolean isFull() {
        return top == stack.length;
    }
    /**
     * returns top element.
     *
     * @return     { description_of_the_return_value }
     */
    char gettop() {
        return stack[top - 1];
    }

}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Determines if balanced.
     *
     * @param      str   The string
     *
     * @return     True if balanced, False otherwise.
     */
    public String isBalanced(final String str) {
        //System.out.println(str);
        Stack st = new Stack((str.length()) / 2);
        //System.out.println(Arrays.toString(str.toCharArray()));
        for (char each : str.toCharArray()) {
            //System.out.println("each is   " + each);
            if (each == '{' || each == '[' || each == '(') {
                st.push(each);
            } else {
                //System.out.println(st.gettop());
                if (!st.isEmpty()) {
                    char top = st.gettop();
                    if ((top == '(' && each == ')') || (top == '{'
                     && each == '}') || (top == '[' && each == ']')) {
                        char poppeditem = st.pop();
                    } else {
                        return "NO";
                    }
                } else {
                    return "NO";
                }
            }
        }
        if (st.isEmpty()) {
            return "YES";
        }
        return "NO";
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
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
