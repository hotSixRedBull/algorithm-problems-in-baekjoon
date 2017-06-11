import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		int[] maps = new int[26];
		Arrays.fill(maps, -1);
		for(int i=0;i<input.length();i++){
			if(maps[input.charAt(i)-'a']==-1)
				maps[input.charAt(i)-'a']=i;
		}
		if(maps.length>0)
			System.out.print(maps[0]);
		for(int i=1;i<maps.length;i++){
			System.out.print(" "+maps[i]);
		}
	}

}
