import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt(), num=0;
		String printed="";
		for(int i=0;i<size;i++){
			num = sc.nextInt();
			printed = sc.next();
			for(int j=0;j<printed.length();j++){
				for(int k=0;k<num;k++)
					System.out.print(printed.charAt(j));
			}
			System.out.println();
		}
		sc.close();
	}

}
