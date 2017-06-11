package zzaro;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

class condition{
	public int rx,ry,bx,by,count;
	public char dir;
	public condition(condition c,char dir,int count){
		this.rx = c.rx;
		this.ry = c.ry;
		this.bx = c.bx;
		this.by = c.by;
		this.dir = dir;
		this.count = count;
	}
	public condition() {
		// TODO Auto-generated constructor stub
		this.rx=0;this.ry=0;this.bx=0;this.by=0;this.count=0;this.dir='s';
	}
}

public class maze {
	private static ArrayList<ArrayList<Character>> map;
	private static condition cur;
	private static int ox,oy;
	private static Stack<condition> s;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt(),c = sc.nextInt(),temp=0;
		Boolean end = false;
		s = new Stack<condition>();
		cur = new condition();
		setMap(sc,r,c);
		while(!end){
			temp = lookAround(cur.dir);
			cur = s.peek();
			s.pop();
			end = move(cur);
		}
	}
	public static void setMap(Scanner sc, int r,int c){
		String line = sc.nextLine();
		map = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> minimap = new ArrayList<Character>();
		for(int i=0;i<r;i++){
			line = sc.nextLine();
			minimap = new ArrayList<Character>();
			for(int j=0;j<c;j++){
				minimap.add(line.charAt(j));
				switch(line.charAt(j)){
				case 'R':
					cur.rx = i;
					cur.ry = j;
					break;
				case 'B':
					cur.bx = i;
					cur.by = j;
					break;
				case 'O':
					ox = i;
					oy = j;
					break;
				default:
					break;
				}
			}
			map.add(minimap);
		}
	}
	public static int lookAround(char from){
		int size = s.size();
		if(map.get(cur.rx-1).get(cur.ry) != '#' && map.get(cur.rx-1).get(cur.ry) != 'B' && from != 'd')
			s.push(new condition(cur,'u',cur.count));
		if(map.get(cur.rx+1).get(cur.ry) != '#' && map.get(cur.rx+1).get(cur.ry) != 'B' && from != 'u')
			s.push(new condition(cur,'d',cur.count));
		if(map.get(cur.rx).get(cur.ry-1) != '#' && map.get(cur.rx).get(cur.ry-1) != 'B' && from != 'r')
			s.push(new condition(cur,'l',cur.count));
		if(map.get(cur.rx).get(cur.ry+1) != '#' && map.get(cur.rx).get(cur.ry+1) != 'B' && from != 'l')
			s.push(new condition(cur,'r',cur.count));
		return s.size() - size;
	}
	
	public static Boolean move(condition c){
		ArrayList<Integer> printed = new ArrayList<Integer>();
		Boolean end = false;
		//System.out.println("("+c.rx+","+c.ry+") to "+c.dir);
		if(++c.count>=10){
			System.out.println(-1);
			return true;
		}
		switch(cur.dir){
		case 'u':
			//r moves
			while(map.get(cur.rx-1).get(cur.ry)!='#'){
				if(map.get(cur.rx-1).get(cur.ry)=='B'){
					break;
				}else cur.rx--;
				if(ox == cur.rx && oy == cur.ry){
					printed.add(1);
					//System.out.println(cur.count);
					end = true;
				}
			}
			//b moves
			while(map.get(cur.bx-1).get(cur.by)!='#'){
				if(map.get(cur.bx-1).get(cur.by)=='R' && !end){
					break;
				}
				else cur.bx--;
				if(ox == cur.bx && oy == cur.by){
					printed.add(0);
					//System.out.println(-1);
					end = true;
				}
			}
			// r final moves must be added
			break;
		case 'd':
			//r moves
			while(map.get(cur.rx+1).get(cur.ry)!='#'){
				if(map.get(cur.rx+1).get(cur.ry)=='B'){
					break;
				}else cur.rx++;
				if(ox == cur.rx && oy == cur.ry){
					printed.add(1);
					//System.out.println(cur.count);
					end = true;
				}
			}
			//b moves
			while(map.get(cur.bx+1).get(cur.by)!='#'){
				if(map.get(cur.bx+1).get(cur.by)=='R' && !end){
					break;
				}
				else cur.bx++;
				if(ox == cur.bx && oy == cur.by){
					printed.add(0);
					//System.out.println(-1);
					end = true;
				}
			}
			// r final moves must be added
			break;
		case 'l':
			//r moves
			while(map.get(cur.rx).get(cur.ry-1)!='#'){
				if(map.get(cur.rx).get(cur.ry-1)=='B'){
					break;
				}else cur.ry--;
				if(ox == cur.rx && oy == cur.ry){
					printed.add(1);
					//System.out.println(cur.count);
					end = true;
				}
			}
			//b moves
			while(map.get(cur.bx).get(cur.by-1)!='#'){
				if(map.get(cur.bx).get(cur.by-1)=='R' && !end){
					break;
				}
				else cur.by--;
				if(ox == cur.bx && oy == cur.by){
					printed.add(0);
					//System.out.println(-1);
					end = true;
				}
			}
			// r final moves must be added
			break;
		case 'r':
			//r moves
			while(map.get(cur.rx).get(cur.ry+1)!='#'){
				if(map.get(cur.rx).get(cur.ry+1)=='B'){
					break;
				}else cur.ry++;
				if(ox == cur.rx && oy == cur.ry){
					printed.add(1);
					//System.out.println(cur.count);
					end = true;
				}
			}
			//b moves
			while(map.get(cur.bx).get(cur.by+1)!='#'){
				if(map.get(cur.bx).get(cur.by+1)=='R' && !end){
					break;
				}
				else cur.by++;
				if(ox == cur.bx && oy == cur.by){
					printed.add(0);
					//System.out.println(-1);
					end = true;
				}
			}
			// r final moves must be added
			break;
		default:
			break;
		}
		if(printed.size()>0){
			System.out.println(printed.get(printed.size()-1));
		}
		return end;
	}
}
