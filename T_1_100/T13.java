package T_1_100;

import java.util.HashMap;
import java.util.Map;

public class T13 {
	
    public static  int romanToInt(String s) {
    	Map<Character,Integer> roman =  new HashMap<Character,Integer>();
    	roman.put('M', 1000);
    	roman.put('D', 500);
    	roman.put('C', 100);
    	roman.put('L', 50);
    	roman.put('X', 10);
    	roman.put('V', 5);
    	roman.put('I', 1);
    	
    	int len = s.length();
    	int ans = roman.get(s.charAt(len-1));
    	int current = roman.get(s.charAt(len-1));
    	for (int i = len-2;i>=0;i--){
    		if(current>roman.get(s.charAt(i))){
    			ans-=roman.get(s.charAt(i));
    			
    		}else{
    			ans+=roman.get(s.charAt(i));
    		}
    		current = roman.get(s.charAt(i));
    	}

    	return ans;
    }
    
	public static void main(String []args){
		System.out.println(romanToInt("MCMXCIV"));
	}
}
