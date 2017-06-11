import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        for(int i=0;i<line.length();i+=10){
        		if(i+10<line.length())
        			System.out.println(line.substring(i,i+10));
        		else
        			System.out.println(line.substring(i));
        }
        
        sc.close();
        int[][] a = null;
        int temp = a.length;
	}

}
