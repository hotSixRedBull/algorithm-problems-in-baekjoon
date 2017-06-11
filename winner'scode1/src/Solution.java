import java.util.Arrays;

public class Solution {
		public static void main(String[] args){
			nearestPalindromic("88");
		}
	    public static String nearestPalindromic(String n) {
	        long z = Long.parseLong(n);
	        long x = bigger(z+1);
	        long y = smaller(z-1);
	        assert x >= z;
	        assert z >= y;
	        if(x - z < z - y){
	        	return Long.toString(x);
	        }else{
	        	return Long.toString(y);
	        }
	    }
	    
	    static long bigger(long u)
	    {
	    	char[] s = Long.toString(u).toCharArray();
	        int m = s.length;
	        char[] t = Arrays.copyOf(s, m);
	        for(int i = 0;i < m/2;i++){ //t는 그냥 바로 팰린드롬을 만든거임.
	        	t[m-1-i] = t[i];
	        }
	        for(int i = 0;i < m;i++){
        		if(s[i] > t[i]){
        			for(int j = (m-1)/2;j >= 0;j--){ //s의 인덱스가 크다면, 
        				if(++t[j] > '9'){ //t가 9일때 0으로 바꿔버림.
        					t[j] = '0';
        				}else{
        					break;
        				}
        			}
        	        for(int j = 0;j < m/2;j++){ //그리고 다시 팰린드롬을 만듦.
        	        	t[m-1-j] = t[j];
        	        }
        	        return Long.parseLong(new String(t));
        		}else if(s[i] < t[i]){ //t가 더 크면 그냥 리턴해버리네? 
        	        return Long.parseLong(new String(t));
        		}
	        }
	        return Long.parseLong(new String(t));
	    }
	    
	    static long smaller(long u)
	    {
	    	char[] s = Long.toString(u).toCharArray();
	        int m = s.length;
	        char[] t = Arrays.copyOf(s, m);
	        for(int i = 0;i < m/2;i++){
	        	t[m-1-i] = t[i];
	        }
	        for(int i = 0;i < m;i++){
        		if(s[i] > t[i]){
        	        return Long.parseLong(new String(t));
        		}else if(s[i] < t[i]){
        			for(int j = (m-1)/2;j >= 0;j--){
        				if(--t[j] < '0'){
        					t[j] = '9';
        				}else{
        					break;
        				}
        			}
        			if(t[0] == '0'){
        				if(t.length == 1){
        					return 0;
        				}
        				t = new char[m-1];
        				Arrays.fill(t, '9');
        				return Long.parseLong(new String(t));
        			}
        	        for(int j = 0;j < m/2;j++){
        	        	t[m-1-j] = t[j];
        	        }
        	        return Long.parseLong(new String(t));
        		}else if(s[i] > t[i]){
        	        return Long.parseLong(new String(t));
        		}
	        }
	        return Long.parseLong(new String(t));
	    }
	}	