import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sum=0,check=0;
		for(int i=0;i<5;i++){
			check = sc.nextInt();
			if(check>40)
				sum += check;
			else
				sum += 40;
		}
		System.out.println(sum/5);
	}

}
