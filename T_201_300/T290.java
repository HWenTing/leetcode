package T_201_300;

import java.util.HashMap;

public class T290 {

	
//	给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
//	这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
	
//	遍历 n^2复杂度  击败15%。。
//    public boolean wordPattern(String pattern, String str) {
//        String[] strs = str.split(" ");
//        int len = strs.length;
//        if(len!=pattern.length())return false;
//        
//        for(int i=0;i<len-1;i++){
//        	for(int j=i+1;j<len;j++){
//        		if((pattern.charAt(i)==pattern.charAt(j) && !strs[i].equals(strs[j]))
//        				||(pattern.charAt(i)!=pattern.charAt(j) && strs[i].equals(strs[j])))
//        			return false;
//        	}
//        }
//        return true;
//    }
    
	
//	用hashmap呀。。。
//	击败100%
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        int len = strs.length;
        if(len!=pattern.length())return false;
        
        HashMap<Character,String> map = new HashMap<>();
        for(int i=0;i<len;i++){
        	if(map.containsKey(pattern.charAt(i))){
        		if(!map.get(pattern.charAt(i)).equals(strs[i]))
        			return false;
        	}else{
        		if(map.containsValue(strs[i])) return false;
        		map.put(pattern.charAt(i), strs[i]);
        	}
        }
        return true;
    }
    
}
