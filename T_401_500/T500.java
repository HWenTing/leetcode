package T_401_500;

import java.util.Arrays;
import java.util.HashMap;

public class T500 {

	
//	给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
	
    public String[] findWords(String[] words) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:"qwertyuiop".toCharArray())
        	map.put(c, 1);
        for(char c:"asdfghjkl".toCharArray())
        	map.put(c, 2);
        for(char c:"zxcvbnm".toCharArray())
        	map.put(c, 3);
        
        int cnt=0;
        for(String s:words){
        	if(check(s,map)){
        		words[cnt]=s;
        		cnt++;
        	}
        }
        return Arrays.copyOf(words, cnt);
    }

	private boolean check(String s, HashMap<Character, Integer> map) {
		if(s.length()<2)
			return true;
		s=s.toLowerCase();
		int type = map.get(s.charAt(0));
		for(char c:s.toCharArray()){
			if(map.get(c)!=type)
				return false;
		}
		return true;
	}
    
}
