import java.util.Scanner;
import java.util.ArrayList;
class Details{
	private String name;
	private int wins;
	private int lost;
	private int draws;
	Details(String name, int wins, int lost, int draws){
		this.name = name;
		this.wins = wins;
		this.lost = lost;
		this.draws = draws;
	}
	String getname(){
		return this.name;
	}
	int getwins(){
		return this.wins;
	}
	int getlost(){
		return this.lost;
	}
	int getdraws(){
		return this.draws;
	}
}
class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Details[] list = new Details[10];
		int n = 0;
		while(sc.hasNextLine()){
			String[] tokens = sc.nextLine().split(",");
			list[n++] = new Details(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
		}
		for(int  i = 0; i < n; i++){
			int min = i;
			for(int j = i+1; j < n; j++){
				if(list[j].getwins() == (list[min].getwins())){
					if(list[j].getlost() == (list[min].getlost())){
						if(list[j].getdraws() > list[min].getdraws()){
							min = j;
						} 
					} else{
						if (list[j].getlost() < list[min].getlost()){
							min = j;
						}
					}
				} else{
					if(list[j].getwins() > list[min].getwins()){
						min = j;
					}
				}
			}
			Details temp = list[i];
			list[i] = list[min];
			list[min] = temp;
		}
		for(int i = 0; i < n-1; i++){
			System.out.print(list[i].getname() + ",");
		}
		System.out.print(list[n-1].getname());
	}
}