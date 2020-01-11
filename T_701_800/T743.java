package T_701_800;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class T743 {

//	最短路径问题
//	dijkstra
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer,Integer> map = new HashMap<>();//存储k到各个点的距离
        for(int i=0;i<N;i++)
        	map.put(i, Integer.MAX_VALUE);
        
        int[][] adj = new int[N][N];
        for(int[] i:adj)
        	Arrays.fill(i, -1);
        
        for(int[] edge:times)
        	adj[edge[0]-1][edge[1]-1] = edge[2];
        
        for(int i=0;i<N;i++){
        	if(adj[K-1][i]>=0){
        		map.put(i, adj[K-1][i]);
        	}
        }
        
        map.remove(K-1);
        
        int ans=0;
        int count=N-1;
        while(count>0){
        	int nextadd = findMin(map);
        	if(nextadd<0 || map.get(nextadd)==Integer.MAX_VALUE)return -1;
        	ans = map.get(nextadd);
        	
        	map.remove(nextadd);
        	for(int i=0;i<N;i++){
        		if(map.containsKey(i) && adj[nextadd][i]>=0 && adj[nextadd][i]+ans<map.get(i)){
        			map.put(i, adj[nextadd][i]+ans);
        		}
        	}
        	count--;
        }
        return ans;
    	
    }
    
    private int findMin(HashMap<Integer,Integer> map){
    	int key=-1;
    	int min = Integer.MAX_VALUE;
    	for(Entry<Integer,Integer> e:map.entrySet()){
    		if(e.getValue()<min){
    			key = e.getKey();
    			min = e.getValue();
    		}
    	}
    	return key;
    }
}
