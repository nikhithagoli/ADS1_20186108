import java.util.Scanner;
class Details{
	private String name;
	private String dob;
	private int subject1;
	private int subject2;
	private int subject3;
	private int total;
	private String category;
	Details(String n, String d, int s1, int s2, int s3, int t, String rc){
		this.name = n;
		this.dob = d;
		this.subject1 = s1;
		this.subject2 = s2;
		this.subject3 = s3;
		this.total = t;
		this.category = rc;
	}

	String getname(){
		return this.name;
	}

	String getdob(){
		return this.dob;
	}

	int getsubject1(){
		return this.subject1;
	}

	int getsubject2(){
		return this.subject2;
	}

	int getsubject3(){
		return this.subject3;
	}

	int gettotal(){
		return this.total;
	}

	String getcategory(){
		return this.category;
	}
	int getage(){
		int age = 0;
		String[] token = this.getdob().split("-");
		age += (2018 - Integer.parseInt(token[2]))*365; 
		age += (10 - Integer.parseInt(token[1]))*30;
		age += Integer.parseInt(token[0]);

		return age;
	}
	public int compareTo(final Details that) {
        if (this.gettotal() > that.gettotal()){
        	return 1;
        } else if (this.gettotal() < that.gettotal()){
        	return -1;
        } else {
        	if(this.getsubject3() > that.getsubject3()){
        		return 1;
        	} else if (this.getsubject3() < that.getsubject3()){
        		return -1;
        	} else {
        		if(this.getsubject2() > that.getsubject2()){
        			return 1;
        		} else if(this.getsubject2() < that.getsubject2()){
        			return -1;
        		} else{
        			if(this.getage() < that.getage()){
        				return 1;
        			} else{
        				return -1;
        			}
        		}
        	}
        }

    }
    String print(){
    	return this.getname() + "," + this.gettotal() + "," + this.getcategory();
    }
}
class Solution{
	static Details[] selectionsort(final Details[] students, final int n) {
        for (int  i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (students[j].compareTo(students[min]) > -1) {
                    min = j;
                }
            }
            Details temp = students[i];
            students[i] = students[min];
            students[min] = temp;
        }
        return students;
    }
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		int vacancies = Integer.parseInt(scan.nextLine());
		int open = Integer.parseInt(scan.nextLine());
		int bc = Integer.parseInt(scan.nextLine());
		int sc = Integer.parseInt(scan.nextLine());
		int st = Integer.parseInt(scan.nextLine());
		Details[] students = new Details[n];
		for(int i = 0; i < n; i++){
			String[] input = scan.nextLine().split(",");
			students[i] = new Details(input[0], input[1], Integer.parseInt(input[2]),
			 Integer.parseInt(input[3]), Integer.parseInt(input[4]),
			  Integer.parseInt(input[5]), input[6]);
		}
		students = selectionsort(students, n);
		for(int i = 0; i < n; i++){
			System.out.println(students[i].print());
		}
		System.out.println();
		for(int j = 0; j < open; j++){
			System.out.println(students[j].print());
		}
					
		for(int k = open; k < n; k++){
			if(students[k].getcategory().equals("BC") && bc > 0){
				System.out.println(students[k].print());
				bc--;
			} else if(students[k].getcategory().equals("SC") && sc > 0){
				System.out.println(students[k].print());
				sc--;
			} else if(students[k].getcategory().equals("ST") && st > 0){
				System.out.println(students[k].print());
				st--;
			}
		}
	}
}