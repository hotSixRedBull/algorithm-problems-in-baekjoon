import java.util.HashMap;
import java.util.Scanner;
class pair{
	int a;int b;
	public pair(int i,int j){
		a = i;b = j;
	}
}
public class fibo {
	public static HashMap<Integer,pair> check;
	public static pair f(int a){
		if(!check.containsKey(a)){
			pair p = new pair(0,0);
			p.a = f(a-1).a+f(a-2).a;
			p.b = f(a-1).b+f(a-2).b;
			check.put(a, p);
		}
		return check.get(a);
	}
	public static void main(String[] args){
		check = new HashMap<Integer,pair>();
		check.put(0, new pair(1,0));
		check.put(1, new pair(0,1));
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		for(int i=0;i<cases;i++){
			int a = sc.nextInt();
			System.out.println(f(a).a+" "+f(a).b);
		}

	}
}
