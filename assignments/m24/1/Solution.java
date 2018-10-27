import java.util.Scanner;
import java.util.HashMap;
class Student {
	//private Integer rollnumber;
	private String name;
	private Double totalmarks;
	Student(String n, Double t) {
		//this.rollnumber = r;
		this.name = n;
		this.totalmarks = t;
	}
	/*Integer getrollnumber() {
		return this.rollnumber;
	}*/
	String getname() {
		return this.name;
	}
	Double gettotalmarks() {
		return this.totalmarks;
	}
}
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		HashMap<Integer, Student> h = new HashMap<Integer, Student>(n);
		for(int i = 0; i < n; i++) {
			String[] input = sc.nextLine().split(",");
			h.put(Integer.parseInt(input[0]), new Student(input[1], Double.parseDouble(input[2])));
		}
		int m = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < m; i++) {
			String[] input = sc.nextLine().split(" ");
			Student s = h.get(Integer.parseInt(input[1]));
			if(input[2].equals("1")) {
				System.out.println(s.getname());
			} else {
				System.out.println(s.gettotalmarks());
			}
		}
	}
}