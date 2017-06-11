import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class Main {
   public static int[] check;
   public static int get(int i){
    if(i==1) return 0;
    if(i<0) return 987654321;
    if(check[i] != -1) return check[i];
         int min = i;//초기값 설정
         if(i%3==0) {
               min =Math.min(min,get(i/3)+1);
         }
         if(i%2==0){
               min =Math.min(min,get(i/2)+1);
         }
       min =Math.min(min,get(i-1)+1);
       check[i]=min;
    return check[i];
    }
   public static void main(String[] args){
      check = new int[1000001];
      Arrays.fill(check,-1);
      Scanner sc = new Scanner(System.in);
      int num = sc.nextInt();
      System.out.println(get(num));
   }
}