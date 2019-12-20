package T_101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T126 {
//	给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
//
//	每次转换只能改变一个字母。
//	转换过程中的中间单词必须是字典中的单词。
//	说明:
//
//	如果不存在这样的转换序列，返回一个空列表。
//	所有单词具有相同的长度。
//	所有单词只由小写字母组成。
//	字典中不存在重复的单词。
//	你可以假设 beginWord 和 endWord 是非空的，且二者不相同。

//	想法是构造图，通过一步可以相互转换的两个单词构造一条边。
//	然后bfs，保存父节点的下标，以方便输出路径
//	重点是 多条路径的问题。
//	一个节点可能有多个父节点，需要list存储 。 同一节点只保存距离begin最近的父亲节点，可能有多个
	
	List<List<String>> ans;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    	ans = new LinkedList<>();
        wordList.add(0,beginWord);
        int n = wordList.size();
        int i;
        for (i=0;i<n;i++){
        	if(wordList.get(i).equals(endWord))
        		break;
        }
    	if(i==n){
    		return ans;
    	}
    	List<Integer>[] graph = makeGraph(wordList); 	

    	List<Integer>[] parent = minpath(graph,0,i);
    		
    	List<String> temp = new LinkedList<>();
    	temp.add(endWord);
    	getpath(parent,wordList,i,temp);
    	return ans;
    	
    }
//    根据保存的父节点索引构建路径
    private void getpath(List<Integer>[] parent ,List<String> wordList,int pos,List<String> item){
    	if(pos==0){
    		ans.add(new LinkedList<>(item));
    		return;
    	}
    	
    	for(int i:parent[pos]){
    		item.add(0,wordList.get(i));
    		getpath(parent,wordList,i,item);
    		item.remove(0);
    	}
    }
    
//    通过图，bfs来找到到达end的最短路
    private List<Integer>[] minpath(List<Integer>[] graph,int start,int end){
    	
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(start);
    	int level = 0;
    	int[] isvisited = new int[graph.length];
    	List<Integer>[] parent = new List[graph.length];//存储父节点索引
    	for (int i=0;i<graph.length;i++)
    		parent[i] = new LinkedList<Integer>();
    	parent[0].add(0);
    	
    	int stop=graph.length+2;
    	while(!queue.isEmpty() && level<=stop){
    		level++;
    		int size = queue.size();
    		while(size>0){
    			size--;
    			int cur = queue.poll();
    			for (int i :graph[cur]){
    				if(isvisited[i]==0 || level<=isvisited[i]){//如果该节点已经被访问到了，且距离比当前要近，就直接跳过
    					parent[i].add(cur);
    					if(i==end)//找到了最短的长度
    						stop=level;

    					if(isvisited[i]==0)
    						queue.add(i);
    					isvisited[i] = level;
    				}
    			}
    		}
    	}
    	return parent;
    }
    
//    构建图
    private List<Integer>[] makeGraph(List<String> wordList){
    	int n = wordList.size();
    	List<Integer>[] graph = new List[n];
    	for (int i=0;i<n;i++)
    		graph[i] = new ArrayList<Integer>();
    	for (int i=0;i<n;i++){
    		for (int j=i+1;j<n;j++){
    			if(isConnected(wordList.get(i),wordList.get(j))){
    				graph[i].add(j);
    				graph[j].add(i);
    			}
    		}
    	}
    	return graph;
    }
    
//    判断两个单词是否连
    private boolean isConnected(String s1,String s2){
    	int len = s1.length();
    	int count=0;
    	for (int i=0;i<len && count<=1;i++){
    		if(s1.charAt(i)!=s2.charAt(i)){
    			count++;
    		}
    	}
    	return count==1;
    }
    
    public static void main(String[] args) {
    	T126 t = new T126();
    	List<String> wordList = new LinkedList<>();
    	wordList.add("hot");
    	wordList.add("dot");
    	wordList.add("dog");
    	wordList.add("lot");
    	wordList.add("log");
    	wordList.add("cog");
    	
    	List<List<String>> ans = t.findLadders("hit", "cog", wordList);
    	for(int ii=0;ii<ans.size();ii++){
			List<String> now = ans.get(ii);
			System.out.print(ii+": ");
			for(String p:now){
				System.out.print(p+" ");
			}
    	}
	}
    
}
