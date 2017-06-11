import java.util.ArrayList;
import java.util.Scanner;
/*
 * 에러처리
 * 1. stair가 하나만 들어올 경우
 * 2. cur가 음수가 될 경우
 * 런타임 에러가 나는 경우
 * A. 배열 접근
 * 인덱스 0 이하를 접근하나..? x
 * 인덱스를 초과해서 접근할까..? x
 */
//2579 계단오르기
public class Main {
	public static int[] stair;
	public static int[][] check;

	public static int step(int serial, int cur) {
		int max = 0;
		if(cur<=0) return 0;
		if (check[serial][cur] == 0) {
			// 한걸음 전 혹은 두걸음 전
			if (cur == 1)
				return stair[1];
			if (serial == 0) {// 2칸 쩜프해서 내려옴
				// 한 칸 아래랑 두 칸 아래중 최댓값
				if (cur == 2) {
					return stair[1] + stair[2];
				} else {
					max = Math.max(step(1, cur-1), step(0, cur-2));
				}
			} else if (serial == 1) {// 한 칸 내려옴
				// 두 칸 아래
				if (cur == 2) {
					return stair[2];
				} else {
					max = Math.max(max, step(0, cur-2));
				}
			}
			check[serial][cur] = max + stair[cur];
		}
		return check[serial][cur];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stair = new int[301];
		check = new int[2][301];
		stair[0]= 0;
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			stair[i+1] = sc.nextInt();
		}
		check[0][1] = stair[1];
		check[1][1] = stair[1];
		check[0][2] = stair[1] + stair[2];
		check[1][2] = stair[2];
		// 저장 완료
		System.out.println(Math.max(step(1, num), step(0, num)));
	}
}
