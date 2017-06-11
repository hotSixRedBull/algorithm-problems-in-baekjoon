import java.util.Scanner;
//문제는 저장인데..
/*
 * 다이나믹 프로그래밍으로 풀것이다.
 * 중간을 기준으로 양옆으로 나눈다.
 * 최대합은 
 * 1. 중간엘레먼트를 포함하거나
 * 2. 포함하지 않는다.
 */
public class Main {
	public static int[] a;
	public static int findMax(int size){
		int maxEnd=a[0], maxSo =a[0];
		for(int i=1;i<size;i++){
			maxEnd = Math.max(maxEnd+a[i], a[i]);
			maxSo = Math.max(maxSo, maxEnd);
		}
		return maxSo;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		a = new int[100001];
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for(int i=0;i<num;i++){
			a[i]=sc.nextInt();
		}
		System.out.println(findMax(num));
	}

}
