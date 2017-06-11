import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Integer> a;
	public static void main(String[] args) {
		int num=0,b=0,c=0,ret=0;
		a = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		for(int i=0;i<num;i++){
			a.add(sc.nextInt());
		}
		b=sc.nextInt();
		c=sc.nextInt();
		for(int i=0;i<num;i++){
			ret += Math.ceil(((double)a.get(i)-b)/(double)c);
		}
		System.out.println(a.size()+ret);
	}
}
