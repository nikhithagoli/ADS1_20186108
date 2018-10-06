import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for details.
 */
class Details {
    /**
     * name.
     */
    private String name;
    /**
     * dob.
     */
    private String dob;
    /**
     * s1.
     */
    private int subject1;
    /**
     * s2.
     */
    private int subject2;
    /**
     * s3.
     */
    private int subject3;
    /**
     * total.
     */
    private int total;
    /**
     * cat.
     */
    private String category;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     * @param      d     { parameter_description }
     * @param      s1    The s 1
     * @param      s2    The s 2
     * @param      s3    The s 3
     * @param      t     { parameter_description }
     * @param      rc    The rectangle
     */
    Details(final String n, final String d, final int s1,
     final int s2, final int s3, final int t, final String rc) {
        this.name = n;
        this.dob = d;
        this.subject1 = s1;
        this.subject2 = s2;
        this.subject3 = s3;
        this.total = t;
        this.category = rc;
    }
    /**
     * get name.
     *
     * @return     { description_of_the_return_value }
     */
    String getname() {
        return this.name;
    }
    /**
     * get dob.
     *
     * @return     { description_of_the_return_value }
     */
    String getdob() {
        return this.dob;
    }
    /**
     * get s1.
     *
     * @return     { description_of_the_return_value }
     */
    int getsubject1() {
        return this.subject1;
    }
    /**
     * get s2.
     *
     * @return     { description_of_the_return_value }
     */
    int getsubject2() {
        return this.subject2;
    }
    /**
     * s3.
     *
     * @return     { description_of_the_return_value }
     */
    int getsubject3() {
        return this.subject3;
    }
    /**
     * total.
     *
     * @return     { description_of_the_return_value }
     */
    int gettotal() {
        return this.total;
    }
    /**
     * cat.
     *
     * @return     { description_of_the_return_value }
     */
    String getcategory() {
        return this.category;
    }
    /**
     * get age.
     *
     * @return     { description_of_the_return_value }
     */
    int getage() {
        int age = 0;
        final int year = 2018, days = 365, month = 30, ten = 10;
        String[] token = this.getdob().split("-");
        age += (year - Integer.parseInt(token[2])) * days;
        age += (ten - Integer.parseInt(token[1])) * month;
        age += Integer.parseInt(token[0]);

        return age;
    }
    /**
     * compare.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Details that) {
        if (this.gettotal() > that.gettotal()) {
            return 1;
        } else if (this.gettotal() < that.gettotal()) {
            return -1;
        } else {
            if (this.getsubject3() > that.getsubject3()) {
                return 1;
            } else if (this.getsubject3() < that.getsubject3()) {
                return -1;
            } else {
                if (this.getsubject2() > that.getsubject2()) {
                    return 1;
                } else if (this.getsubject2() < that.getsubject2()) {
                    return -1;
                } else {
                    if (this.getage() < that.getage()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        }

    }
    /**
     * prints.
     *
     * @return     { description_of_the_return_value }
     */
    String print() {
        return this.getname() + "," + this.gettotal() + ","
        + this.getcategory();
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
        ///function.
    }
    /**
     * contains.
     *
     * @param      arr   The arr
     * @param      val   The value
     *
     * @return     { description_of_the_return_value }
     */
    static boolean contains(final int[] arr, final int val) {
        for (int n : arr) {
            if (val == n) {
                return true;
            }
        }
        return false;
    }
    /**
     * sorts.
     *
     * @param      students  The students
     * @param      n         { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
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
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int vacancies = Integer.parseInt(scan.nextLine());
        int open = Integer.parseInt(scan.nextLine());
        int bc = Integer.parseInt(scan.nextLine());
        int sc = Integer.parseInt(scan.nextLine());
        int st = Integer.parseInt(scan.nextLine());
        Details[] students = new Details[n];
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(",");
            students[i] = new Details(input[0], input[1],
                 Integer.parseInt(input[2]),
                Integer.parseInt(input[2 + 1]),
                Integer.parseInt(input[2 + 2]),
                Integer.parseInt(input[2 + 2 + 1]), input[2 + 2 + 2]);
        }
        students = selectionsort(students, n);
        for (int i = 0; i < n; i++) {
            System.out.println(students[i].print());
        }
        System.out.println();
        for (int j = 0; j < open; j++) {
            System.out.println(students[j].print());
        }
        int[] indices = new int[bc + sc + st];
        int i = 0;
        for (int k = open; k < n; k++) {
            if (students[k].getcategory().equals("BC") && bc > 0) {
                //System.out.println(students[k].print());
                indices[i++] = k;
                bc--;
            } else if (students[k].getcategory().
                equals("SC") && sc > 0) {
                //System.out.println(students[k].print());
                indices[i++] = k;
                sc--;
            } else if (students[k].getcategory().
                equals("ST") && st > 0) {
                //System.out.println(students[k].print());
                indices[i++] = k;
                st--;
            }
        }
        if (bc > 0) {
            for (int k = open; k < n; k++) {
            if (students[k].getcategory().equals("Open") && bc > 0) {
                    if (!contains(indices, k)) {
                        indices[i++] = k;
                        bc--;
                    }
                }
            }
        }
        if (sc > 0) {
            for (int k = open; k < n; k++) {
            if (students[k].getcategory().equals("Open") && sc > 0) {
                    if (!contains(indices, k)) {
                        indices[i++] = k;
                        sc--;
                    }
                }
            }
        }
        if (st > 0) {
            for (int k = open; k < n; k++) {
            if (students[k].getcategory().equals("Open") && st > 0) {
                    if (!contains(indices, k)) {
                        indices[i++] = k;
                        st--;
                    }
                }
            }
        }
        Arrays.sort(indices);
        for (int k = 0; k < indices.length; k++) {
            System.out.println(students[indices[k]].print());
        }
    }
}