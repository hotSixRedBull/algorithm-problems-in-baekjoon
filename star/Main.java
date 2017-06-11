import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	static int[][] map;
	static int size;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt(); // size = 3*2^n (ex) 3,6,12,24,48,96,192,384,768,1536,3072
		map = new int[size][2 * size]; // row will be 2*size, height will be
		f(0, size,0,0);//first triangle
		for(int i=6;i<=size;i*=2){
			copy_map(i);
		}
		print_map();
		sc.close();
	}

	public static void f(int x, int y,int start,int end) {
		if(start<=end){
			map[x][y]++;
			for (int i = -1; i < 2; i += 2)// next floor
				map[x + 1][y + i]++;
			for (int i = -2; i < 3; i++)// lowest floor of minimum
				map[x + 2][y + i]++;
			if (x + 3 < end) {
				f(x + 3, y - 3,start+2,end);
				f(x + 3, y + 3,start+2,end);
			}
		}
	}
	
	public static void copy_map(int end) {
		//copy to end 3분의 1만 계산해서 아래에 두번 붙여넣기.
		for(int i=end/2;i<end;i++){
			for(int j=0;j<size;j++){//왼쪽아래
				map[i][j] = map[i-end/2][j+end/2];
			}
			for(int j=size;j<size*2;j++){//오른쪽아래
				map[i][j] = map[i-end/2][j-end/2];
			}
		}
	}
	
	public static void print_map() {
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size * 2; j++) {
				if (map[i][j] == 1)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}