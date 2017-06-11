
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1;
		int[] arr = new int[10001];
		while(n!=10000){
			arr[d(n)]++;
			n++;
		}
		for(int i=1;i<10000;i++){
			if(arr[i]==0)
				System.out.println(i);
		}
	}
	public static int d(int n){
		int ret=n;
		for(int i=0;i<=Math.log10((double)n);i++){
			ret += Integer.parseInt(""+String.valueOf(n).charAt(i));
		}
		//System.out.println("d("+n+")="+ret);
		if(ret > 10000) 
			return 0;
		else
			return ret;
	}
}
