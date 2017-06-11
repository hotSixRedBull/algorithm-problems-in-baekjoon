import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,Integer> h = new HashMap<String,Integer>();
		Scanner sc = new Scanner(System.in);
		int res=0;
		String s = sc.nextLine(),temp="";
		Scanner sc2 = new Scanner(s);
		while(sc2.hasNext()){
			temp = sc2.next();
			/*
			if(!h.containsKey(temp)){
				h.put(temp, 1);
			}
			*/
			res++;
		}
		
		System.out.println(res);
		sc.close();
	}

}
