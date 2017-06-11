import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test=sc.nextInt(),seq=0,res=0;
		String ans="";
		sc.nextLine();
		for(int i=0;i<test;i++){
			res=0;
			seq=0;
			ans=sc.nextLine();
			for(char n : ans.toCharArray()){
				if(n=='O'){
					seq++;
					res+=seq;
				}
				else{
					seq=0;
				}
			}
			System.out.println(res);
		}
	}

}
