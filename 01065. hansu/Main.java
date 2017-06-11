import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ret=0,size=0;
		Scanner sc = new Scanner(System.in);
		size=sc.nextInt();
		for(int i=1;i<=size;i++){
			if(hansu(i))
				ret++;
		}
		System.out.println(ret);
	}
	public static boolean hansu(int n){
		int comp=0,before=0;
		for(int i=0;i<=Math.log10((double)n)-1;i++){
			comp = String.valueOf(n).charAt(i+1)-String.valueOf(n).charAt(i);
			if(i!=0 && before != comp)
				return false;
			before = comp;
		}
		//System.out.println(n);
		return true;
	}
}
