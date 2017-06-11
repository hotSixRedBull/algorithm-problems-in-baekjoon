//2156 포도주 시식
//포도주의 양이 음수일 수도 있는게 .. ..ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
//꼭 마지막이나 처음을 안골라도 되는게 함정카드
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int[] wines;
	public static int[][] check;
	public static int num;
	public static int start_drink(int serial,int cur){		//0이면 처음 마신거고, 1은 바로 전 것을 마신 것임
		int max=0;
		if(num <= 0 || cur > num) return 0;					//기저 하핳
		if(check[serial][cur]!=0) return check[serial][cur];//있으면 리턴해라
		if(serial != 1){									//처음 마시는 것임. 즉 한 번 더 가능
			max = Math.max(start_drink(1,cur+1), start_drink(0,cur+2));
		}else if(serial == 1){								//이미 두 잔째이므로 다음으로 넘어가야 함
			max = start_drink(0,cur+2);
		}
		return check[serial][cur] = max+wines[cur];
	}
	public static void main(String[] args) { // TODO Auto-generated method stub
		check = new int[2][10001];
		wines = new int[10001];
		int f=0,s=0;
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		for(int i=0;i<num;i++){
			wines[i+1] = sc.nextInt();
		}
		f = start_drink(0,1);
		Arrays.fill(check[0], 0);Arrays.fill(check[1], 0);
		s = start_drink(0,2);
		//저장 완료
		System.out.println(Math.max(f,s));
	}
}

