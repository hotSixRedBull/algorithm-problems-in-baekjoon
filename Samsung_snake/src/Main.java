import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
class pair{
	char dir;
	BigInteger time;
	public void put(char c,int i){
		dir = c;
		time = new BigInteger(Integer.toString(i));
	}
}

class coor{
	int x;
	int y;
	public void put(int c,int i){
		x = c;
		y = c;
	}
}
 
public class Main {
	static ArrayList<pair> a;
	static HashMap<coor,Integer> map;
	static char cur;
	static int msize;
	public static char rotate(char c){
		if(cur=='e'){
			if(c=='L'){
				return 's';
			}else{
				return 'n';
			}
		}else if(cur=='w'){
			if(c=='L'){
				return 'n';
			}else{
				return 's';
			}
		}else if(cur=='s'){
			if(c=='L'){
				return 'w';
			}else{
				return 'e';
			}
		}else if(cur=='n'){
			if(c=='L'){
				return 'e';
			}else{
				return 'w';
			}
		}
		return cur;
	}
	public static int whenCollide(int x,int y,int index,int t){//g는 몇번째냐, t는 시간
		coor c;
		
		for(int i=0;i<a.get(index).time;i++){
			t++;
			switch(rotate(a.get(index).dir)){
			case 'e':
				c.put(++x, y);
				if(==1 || x>msize)
					return t;
				break;
			case 'w':
				if(x==0 || map[--x][y]==1)
					return t;
				break;
			case 's':
				if(map[x][++y]==1|| y>msize)
					return t;
				break;
			case 'n':
				if(x==0 ||map[x][--y]==1)
					return t;
				break;
			}
			map[x][y]=1;
		}
		return whenCollide(x,y,++index,t);
	}
	public static void main(String[] args) {
		int turn=0,time=0;
		char head;
		cur = 'e';
		pair p = new pair();
		a = new ArrayList<pair>();
		map = new HashMap<coor,Integer>();
		Scanner sc = new Scanner(System.in);
		msize = sc.nextInt();
		turn = sc.nextInt();
		for(int i=0;i<turn;i++){
			time = sc.nextInt();
			head = sc.next().charAt(0);
			p.put(head,time);
			a.add(p);
		}
		System.out.println(whenCollide(msize,msize,0,0));
	}
}
