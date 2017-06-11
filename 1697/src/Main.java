import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int d;
	static int[][] map;
	static Boolean[] visit;
	static int size;

	public static int dfs(int s) {
		int min = 100000;
		visit[s] = true;
		for (int i = 1; i <= size; i++) {
			if (map[s][i] == 1 && visit[i] == false) {
				min  = Math.min(dfs(i),min);
			}
		}
		return min+1;
	}
	public static int dfs(int s,int dep){
		int min=Math.abs(s-d);
		if(s==d) return 1;
		if(dep>Math.abs(s-d)) return 100000;
		if(s>0 && s>d)
			min = Math.min(min, dfs(s-1,dep+1)+1);
		if(s*2 <100000 && s<d)
			min = Math.min(min, dfs(s*2,dep+1)+1);
		if(s<100000 && s<d)
			min = Math.min(min, dfs(s+1,dep+1)+1);
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		visit = new Boolean[100000];
		Arrays.fill(visit, false);
		int s=0;
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		d = sc.nextInt();
		System.out.println(dfs(s,0));
	}

}
