import java.util.Scanner;
import java.util.HashMap;
/**
 * Class for student.
 */
class Student {
	/**
	 * studnet name.
	 */
	private String name;
	/**
	 * student marks.
	 */
	private Double totalmarks;
	/**
	 * Constructs the object.
	 *
	 * @param      n     { parameter_description }
	 * @param      t     { parameter_description }
	 */
	Student(final String n, final Double t) {
		this.name = n;
		this.totalmarks = t;
	}
	/**
	 * gets name.
	 *
	 * @return     { description_of_the_return_value }
	 */
	String getname() {
		return this.name;
	}
	/**
	 * gets marks.
	 *
	 * @return     { description_of_the_return_value }
	 */
	Double gettotalmarks() {
		return this.totalmarks;
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
		//unsed.
	}
	/**
	 * main.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
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
			if(s == null){
				System.out.println("Student doesn't exists...");
			} else {
				if(input[2].equals("1")) {
					System.out.println(s.getname());
				} else {
					System.out.println(s.gettotalmarks());
				}
			}
			
		}
	}
}