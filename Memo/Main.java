import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		ArrayList<Float> ar = new ArrayList<Float>();
		Scanner sc = new Scanner(System.in);
		int goal=0;
		goal = sc.nextInt();
		int temp = goal%10*10+(goal/10+goal%10)%10;
		int result=1;
		while(goal != temp){
			temp = temp%10*10+(temp/10+temp%10)%10;
			result++;
		}
		System.out.println(result);
	}
}
