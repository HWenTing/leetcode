package T_101_200;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T187 {
//	所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。
//	在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
//	编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
	
//	第一反应是hashmap存下来，每次移一位判断。击败35%
	
//    public List<String> findRepeatedDnaSequences(String s) {
//    	HashMap<String,Integer> map = new HashMap<>();
//    	List<String> ans = new LinkedList<>();
//    	
//    	if(s.length()<=10)
//    		return ans;
//    	
//    	int right=10;
//    	StringBuffer sb = new StringBuffer();
//    	for(int i=0;i<10;i++)
//    		sb.append(s.charAt(i));
//    	map.put(sb.toString(), 1);
//    	
//    	while(right<s.length()){
//    		sb.deleteCharAt(0);
//    		sb.append(s.charAt(right));
//    		String temp = sb.toString();
//
//    		if(map.containsKey(temp)){
//    			int cur = map.get(temp);
//    			if(cur==1){
//    				ans.add(temp);
//    			}
//    			map.put(temp, cur+1);
//    			
//    		}else{
//            	map.put(temp, 1);
//    		}
//    		right++;
//    	}
//    	return ans;
//    }
	
//	位运算 
//	因为10位，总共四种字母，可以编号，两位即可，这样总共20位，一个int即可表示。
//	击败55%
	private char[] mapnum;
    public List<String> findRepeatedDnaSequences(String s) {
    	HashMap<Integer,Integer> map = new HashMap<>();
    	List<String> ans = new LinkedList<>();
    	HashMap<Character,Integer> mapchar = new HashMap<>();
    	mapchar.put('A', 0);mapchar.put('C', 1);mapchar.put('G', 2);mapchar.put('T', 3);
    	mapnum = new char[]{'A','C','G','T'}; 
    	
    	if(s.length()<=10)
    		return ans;
    	
    	int right=10;
    	int curval = 0;
    	for(int i=0;i<10;i++){
    		curval<<=2;
    		curval = curval|mapchar.get(s.charAt(i));
    		
    	}
    	map.put(curval, 1);
    	
    	while(right<s.length()){
    		curval<<=2;
    		curval = curval|mapchar.get(s.charAt(right));
    		curval = curval&0xfffff;//只保留20位
    		

    		if(map.containsKey(curval)){
    			int cur = map.get(curval);
    			if(cur==1){
    				ans.add(change(curval));
    			}
    			map.put(curval, cur+1);
    			
    		}else{
            	map.put(curval, 1);
    		}
    		right++;
    	}
    	return ans;
    }
    
    private String change(int val){
    	StringBuffer sb = new StringBuffer();
    	for(int i=0;i<10;i++){
    		sb.append(mapnum[val &3]);
    		val>>=2;
    	}
    	return sb.reverse().toString();
    }
    
}
