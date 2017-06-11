import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a=0,b=0,c=0;
		int[] nums = new int[10];
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		BigInteger bi = new BigInteger("1");
		bi = bi.multiply(BigInteger.valueOf(a));
		bi = bi.multiply(BigInteger.valueOf(b));
		bi = bi.multiply(BigInteger.valueOf(c));
		for(char i : bi.toString().toCharArray()){
			nums[Integer.parseInt(""+i,10)]++;
		}
		for(int i : nums){
			System.out.println(i);
		}
		sc.close();
	}

}
