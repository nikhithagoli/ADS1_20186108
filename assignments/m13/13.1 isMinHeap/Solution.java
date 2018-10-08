import java.util.Scanner;
import java.lang.Comparable;
class Minheap {
    public boolean isHeap(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (2 * i + 1 < a.length && 2 * i + 2 < a.length) {
                if (a[i].compareTo(a[2 * i + 1]) > 0 || a[i].compareTo(a[2 * i + 2]) > 0) {
                    return false;
                }
            }

        }
        return true;
    }
}
class Solution {
    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        int nooftestcases = sc.nextInt();
        Minheap m = new Minheap();
        sc.nextLine();
        for (int i = 0; i < nooftestcases; i++) {
            String[] input = sc.nextLine().split(",");
            switch (type) {
            case "String":
                size  = 0;
                String[] stringheap = new String[input.length];
                for (int j = 0; j < input.length; j++) {
                    stringheap[size++] = input[j];
                }
                System.out.println(m.isHeap(stringheap));
                break;
            case "Integer":
                size = 0;
                Integer[] intheap = new Integer[input.length];
                for (int j = 0; j < input.length; j++) {
                    intheap[size++] = Integer.parseInt(input[j]);
                }
                System.out.println(m.isHeap(intheap));
                break;
            case "Float":
                size = 0;
                Float[] floatheap = new Float[input.length];
                for (int j = 0; j < input.length; j++) {
                    floatheap[size++] = Float.parseFloat(input[j]);
                }
                if(size != 0){
                    System.out.println(m.isHeap(floatheap));
                } else {
                    System.out.println("false");
                }   
                break;
            case "Double":
                size = 0;
                Double[] doubleheap = new Double[input.length];
                for (int j = 0; j < input.length; j++) {
                    doubleheap[size++] = Double.parseDouble(input[j]);
                }
                System.out.println(m.isHeap(doubleheap));
                break;


            }
        }
    }
}