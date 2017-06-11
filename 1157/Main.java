import java.util.Scanner;

public class Main {
	static int[] map;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		map = new int[26];
		for(int i=0;i<s.length();i++){
			map[Character.toLowerCase(s.charAt(i))-'a']++;
		}
		int ret = findMax();
		if(howManyMax(ret)==1)
			System.out.println(Character.toUpperCase((char)ret));
		else
			System.out.println('?');
		sc.close();
	}
	public static int findMax(){
		int val=0,ret=0;
		for(int i=0;i<26;i++){
			if(val<map[i]){
				ret = i + 'a';
				val = map[i];
			}
		}
		return ret;
	}
	
	public static int howManyMax(int r){
		int ret=0;
		for(int i=0;i<26;i++){
			if(map[i]==map[r-'a'])
				ret++;
		}
		return ret;
	}

}
