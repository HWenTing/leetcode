package T_101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int n = wordList.size();
        int i;
        for (i=0;i<n;i++){
        	if(wordList.get(i).equals(endWord))
        		break;
        }
    	if(i==n){
    		return 0;
    	}
    	return minpath(makeGraph(wordList),n-1,i);
    	
    }
    
    private int minpath(List<Integer>[] graph,int start,int end){
    	
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(start);
    	int level = 1;
    	boolean[] isvisited = new boolean[graph.length+1];
    	while(!queue.isEmpty()){
    		level++;
    		int size = queue.size();
    		while(size>0){
    			size--;
    			int cur = queue.poll();
    			for (int i :graph[cur]){
    				if(!isvisited[i]){
    					if(i==end)
    						return level;

    					isvisited[i] = true;
    					queue.add(i);

    				}
    			}
    		}
    	}
    	return 0;
    	
    }
    
    
    private List<Integer>[] makeGraph(List<String> wordList){
    	int n = wordList.size();
    	List<Integer>[] graph = new List[n];
    	for (int i=0;i<n;i++){
    		graph[i] = new ArrayList<Integer>();
    		for (int j=0;j<n;j++){
    			if(isConnected(wordList.get(i),wordList.get(j)))
    				graph[i].add(j);
    		}
    	}
    	return graph;
    }
    
    private boolean isConnected(String s1,String s2){
    	int len = s1.length();
    	int count=0;
    	for (int i=0;i<len;i++){
    		if(s1.charAt(i)!=s2.charAt(i)){
    			count++;
    		}
    	}
    	return count==1;
    }
    
    public static void main(String[] args){
    	T127 t = new T127();
    	String beginWord = "hit";
    	String endWord = "cog";
    	List<String> wordList = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
    			
    	System.out.println(t.ladderLength(beginWord, endWord, wordList));

    }
}
