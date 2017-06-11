import java.util.Scanner;
import java.util.*;

public class Main {
	static int[][] map;
	static Boolean[] visit;
	static int size;

	public static void dfs(int s) {
		System.out.print(s + " ");
		visit[s] = true;
		for (int i = 1; i <= size; i++) {
			if (map[s][i] == 1 && visit[i] == false) {
				dfs(i);
			}
		}

	}

	public static void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(s);

		while (!q.isEmpty()) {
			int temp = q.poll();
			visit[temp] = true;
			System.out.print(temp + " ");

			for (int i = 0; i <= size; i++) {
				if (map[temp][i] == 1 && visit[i] == false) {
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[1001][1001];
		visit = new Boolean[10001];
		Arrays.fill(visit, false);
		int edge = 0, start = 0, x, y;
		size = sc.nextInt();
		edge = sc.nextInt();
		start = sc.nextInt();
		for (int i = 0; i < edge; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			map[x][y] = 1;
			map[y][x] = 1;
		}
		dfs(start);
		System.out.println();
		Arrays.fill(visit, false);
		bfs(start);
	}
}
