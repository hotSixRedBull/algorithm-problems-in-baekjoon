import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>(),al2=new ArrayList<Integer>();
		int flag=0;
		for(int i=0;i<8;i++){
			al.add(sc.nextInt());
			al2.add(al.get(i));
		}
		//ascending
		Collections.sort(al);
		for(int i=0;i<8;i++){
			if(al.get(i)!=al2.get(i))
				break;
			if(i==7)
				flag=1;
		}
		Collections.sort(al, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2){
				return o2.compareTo(o1);
			}
		});
		for(int i=0;i<8;i++){
			if(al.get(i)!=al2.get(i))
				break;
			if(i==7)
				flag=2;
		}
		
		switch(flag){
		case 0:
			System.out.println("mixed");
			break;
		case 1:
			System.out.println("ascending");
			break;
		case 2:
			System.out.println("descending");
			break;
		}
	}

}

