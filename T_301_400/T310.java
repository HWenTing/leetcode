package T_301_400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class T310 {

	
//	第一反应是 对每个点向外bfs，或者从叶节点开始
//	某个点距离所有叶节点距离的最大值。
//	对应该没问题。。就是超时了。。。
//	int[] cnt;
//	HashMap<Integer,HashSet<Integer>> map;
//	int n;
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//    	this.n=n;
//        cnt = new int[n];
//        map = new HashMap<>();
//        for(int i=0;i<n;i++){
//        	map.put(i, new HashSet<>());
//        }
//        
//        for(int[] edge:edges){
//        	map.get(edge[0]).add(edge[1]);
//        	map.get(edge[1]).add(edge[0]);
//        }
//        
//        for(Map.Entry<Integer, HashSet<Integer>> entry : map.entrySet()){
//        	if(entry.getValue().size()==1)
//        		bianli(entry.getKey());
//        }
//        
//        int min=Integer.MAX_VALUE;
//        List<Integer> ans = new LinkedList<>();
//        for(int i=0;i<n;i++){
//
//        	if(cnt[i]<min){
//        		ans.clear();
//        		ans.add(i);
//        		min=cnt[i];
//        	}else if(cnt[i]==min)
//        		ans.add(i);
//        }
//        
//        return ans;
//        
//    }
//    
//    private void bianli(int leaf){//从一个叶节点bfs遍历到全部节点，更新长度
//    	int num=1;
//    	cnt[leaf]=Math.max(cnt[leaf], num);
//    	boolean[] visit = new boolean[n];
//    	visit[leaf]=true;
//    	Queue<Integer> queue = new LinkedList<>();
//    	for(Integer i:map.get(leaf))
//    		queue.add(i);
//    	
//    	while(!queue.isEmpty()){
//    		int len = queue.size();
//    		num++;
//    		while(len>0){
//    			len--;
//    			leaf = queue.poll();
//    			visit[leaf]=true;;
//    			cnt[leaf]=Math.max(cnt[leaf], num);
//    	    	for(Integer i:map.get(leaf))
//    	    		if(!visit[i])
//    	    			queue.add(i);
//    		}
//    	}
//    }
	
//	从外边向里层剥
//	二维数组存
//	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//		List<Integer> ans = new LinkedList<>();
//		if(n==1) {
//			ans.add(0);
//			return ans;
//		}
//        
//		int[][] graph = new int[n][n];
//		for(int i=0;i<n;i++)
//			Arrays.fill(graph[i], -1);
//		
//		int[] degree = new int[n];
//		for(int[] edge:edges){
//			graph[edge[0]][degree[edge[0]]]=edge[1];
//			degree[edge[0]]++;
//			graph[edge[1]][degree[edge[1]]]=edge[0];
//			degree[edge[1]]++;
//		}
//		
//		Queue<Integer> queue = new LinkedList<>();
//		for(int i=0;i<n;i++){
//			if(degree[i]==1){
//				queue.add(i);
//			}
//		}
//		
//		int len = n;
//		while(len>2){
//			int qlen = queue.size();
//			len-=qlen;
//			for(int i=0;i<qlen;i++){
//				int node = queue.poll();
//				for(int adj:graph[node]){
//					if(adj==-1) break;
//					degree[adj]--;
//					if(degree[adj]==1)
//						queue.add(adj);
//				}
//			}
//		}
//		while(!queue.isEmpty()){
//			ans.add(queue.poll());
//		}
//		return ans;
//	}
	
	
//	从外边向里层剥
//	使用hashmap来替代二维数组
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> ans = new LinkedList<>();
		if(n==1) {
			ans.add(0);
			return ans;
		}
		
		HashMap<Integer,HashSet<Integer>> graph = new HashMap<>();
		
		int[] degree = new int[n];

		for(int[] edge:edges){
			int left = edge[0];
			int right = edge[1];
			
			if(!graph.containsKey(left)) graph.put(left,new HashSet<>());
			if(!graph.containsKey(right)) graph.put(right,new HashSet<>());
			
			graph.get(left).add(right);
			degree[left]++;
			graph.get(right).add(left);
			degree[right]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<n;i++){
			if(degree[i]==1){
				queue.add(i);
			}
		}
		
		int len = n;
		while(len>2){
			int qlen = queue.size();
			len-=qlen;
			for(int i=0;i<qlen;i++){
				int node = queue.poll();
				for(int adj:graph.get(node)){
					degree[adj]--;
					if(degree[adj]==1)
						queue.add(adj);
				}
				
			}
		}
		
		while(!queue.isEmpty()){
			ans.add(queue.poll());
		}
		return ans;
	}
	
	
	
	
	
	
	
}






