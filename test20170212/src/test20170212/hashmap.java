package test20170212;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class hashmap {
	public static void main(String[] args){
		HashMap<Character,Integer> a1 = new HashMap<Character,Integer>();
		a1.put('Q',1);
		Vector<String> a2 = new Vector<String>();
		a2.add("as");
		for(int i=0;i<args.length;i++){
			a2.add(args[i]);
		}
		String a;
		char sss = 'a';
		System.out.println(Character.toUpperCase(sss));
		String[] st = new String[]{"Hello","Alaska","Dad","Peace"};
		findWords(st);
	}
	public static String[] findWords(String[] words) {
		/*
        HashMap<Character,Integer> fir,sec,thi;
        Vector<String> results = new Vector<String>();
        fir = initHash(1);
        sec = initHash(2);
        thi = initHash(3);
        for(int i=0;i<words.length;i++){
            if(check(fir,words[i])||check(sec,words[i])||check(thi,words[i]))
                results.add(words[i]);
        }
        String[] strings = results.toArray(new String[results.size()]);
        return strings;
        */
		 String[] strs = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
	        Map<Character, Integer> map = new HashMap<>();
	        for(int i = 0; i<strs.length; i++){
	            for(char c: strs[i].toCharArray()){
	                map.put(c, i);//put <char, rowIndex> pair into the map
	            }
	        }
	        List<String> res = new LinkedList<>();
	        for(String w: words){
	            if(w.equals("")) continue;
	            int index = map.get(w.toUpperCase().charAt(0));
	            for(char c: w.toUpperCase().toCharArray()){
	                if(map.get(c)!=index){
	                    index = -1; //don't need a boolean flag. 
	                    break;
	                }
	            }
	            if(index!=-1) res.add(w);//if index != -1, this is a valid string
	        }
	        return res.toArray(new String[0]);
    }
    static Boolean check(HashMap<Character,Integer> hash,String s){
        for(int i=0;i<s.length()-1;i++){
            if(!hash.containsKey(Character.toUpperCase(s.charAt(i))))
                return false;
        }
        return true;
    }
    static HashMap<Character,Integer> initHash(int a){
        HashMap<Character,Integer> init= new HashMap<Character,Integer>();
        switch(a){
            case 1:
                init.put('Q',1);
                init.put('W',1);
                init.put('E',1);
                init.put('R',1);
                init.put('T',1);
                init.put('Y',1);
                init.put('U',1);
                init.put('I',1);
                init.put('O',1);
                init.put('P',1);
                break;
            case 2:
                init.put('A',1);
                init.put('S',1);
                init.put('D',1);
                init.put('F',1);
                init.put('G',1);
                init.put('H',1);
                init.put('J',1);
                init.put('K',1);
                init.put('L',1);
                break;
            case 3:
                init.put('Z',1);
                init.put('X',1);
                init.put('C',1);
                init.put('V',1);
                init.put('B',1);
                init.put('N',1);
                init.put('M',1);
                break;
            default:
                break;
        }
        return init;
    }
}
