import java.util.Scanner;
import java.util.Arrays;
class Stack{
	char[] stack;
	int top;
	Stack(int n){
		stack = new char[n];
		top = 0;
	}
	void push(char item){
		stack[top++] = item;
	}

	char pop(){
		char popped = stack[--top];
		//stack[top--] = '\0';
		return popped;
	}

	boolean isEmpty(){
		return top == 0;
	}

	boolean isFull(){
		return top == stack.length;
	}

	char gettop(){
		return stack[top-1];
	}

}

public class Solution{
	public String isBalanced(String str){
		//System.out.println(str);
		Stack st = new Stack((str.length())/2);
		//System.out.println(Arrays.toString(str.toCharArray()));
		for(char each: str.toCharArray()){
			//System.out.println("each is   " + each);
			if(each == '{' || each == '[' || each == '('){
				st.push(each);
			}
			else{
				//System.out.println(st.gettop());
				if(!st.isEmpty()){
					char top = st.gettop();
					if((top == '(' && each == ')') || (top == '{' && each == '}') || (top == '[' && each == ']')){
						char poppeditem = st.pop();
					} 
					else{
						return "NO";
					}
				} else{
					return "NO";
				}
			}
		}
		if(st.isEmpty()){
			return "YES";
		}
		return "NO";
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution s = new Solution();
		int noOfInputs = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i<noOfInputs; i++){
			String input  = sc.nextLine();
			System.out.println(s.isBalanced(input));
		}
	}
}