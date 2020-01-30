package T_401_500;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public class T433 {

	
//	最短路径
    public int minMutation(String start, String end, String[] bank) {
    	boolean hasend=false;
    	for(String s:bank){
    		if(s.equals(end))
    			hasend=true;
    	}
    	if(!hasend) return -1;
    	
    	HashMap<String,Integer> map = new HashMap<>();
    	int count=0;
    	map.put(start, count);
    	count++;
    	map.put(end, count);
    	count++;
    	for(String s:bank){
    		if(!map.containsKey(s)){
    	    	map.put(s, count);
    	    	count++;
    		}
    	}
    	
    	boolean[][] connect = new boolean[count][count];
    	for(Entry<String,Integer> cur:map.entrySet()){
    		int num = cur.getValue();
    		String key = cur.getKey();
    		for(String s:map.keySet()){
    			if(!s.equals(key) && isconnect(key, s)){
    				connect[num][map.get(s)]=true;
    			}
    		}
    	}
    	
    	boolean[] marked = new boolean[count];
    	marked[0]=true;
    	boolean find=false;
    	
    	int layer=0;
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(0);
    	while(!find && !queue.isEmpty()){
    		layer++;
    		int len = queue.size();
    		for(int i=0;i<len;i++){
    			int cur = queue.poll();
    			for(int j=0;j<count;j++){
    				if(connect[cur][j] && !marked[j]){
    					if(j==1) find=true;
    					queue.add(j);
    					marked[j]=true;
    				}
    			}
    		}
    	}

    	return find?layer:-1;
    }
    
    private boolean isconnect(String s1,String s2){
    	if(s1.length()!=s2.length()) return false;
    	
    	int count=0;
    	for(int i=0;count<2 && i<s1.length();i++){
    		if(s1.charAt(i)!=s2.charAt(i))
    			count++;
    	}
    	return count==1;
    }
}
