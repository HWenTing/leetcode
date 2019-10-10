package T_801_900;

import java.util.HashMap;
import java.util.HashSet;

public class T819 {
//	给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
//	题目保证至少有一个词不在禁用列表中，而且答案唯一。

	
    public String mostCommonWord(String paragraph, String[] banned) {
    	HashSet<String> set = new HashSet<>();
    	HashMap<String,Integer> map = new HashMap<>();
    	String ans="";
    	int max=0;
    	for(String s : banned)
    		set.add(s);
    	banned = paragraph.replaceAll("[!?',;.]", " ").split(" ");
    	for(String s: banned){

    		s=s.toLowerCase();
    		if(!s.equals(" ") && !set.contains(s)){
    			int cnt = map.getOrDefault(s, 0)+1;
    			if(cnt>max){
    				max = cnt;
    				ans = s;
    			}
    			map.put(s, cnt);
    		}
    	}
    	return ans;
    }

}
