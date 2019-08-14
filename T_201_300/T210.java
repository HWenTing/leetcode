package T_201_300;

import java.util.LinkedList;
import java.util.List;

public class T210 {

//	返回一个拓扑排序
//	和207一样
	
	List<Integer> ans ;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	ans = new LinkedList<>();
    	int[] inDegree = new int[numCourses];
    	boolean[] visit = new boolean[numCourses];
    	
    	for(int[] edge :prerequisites)//计算每个点的入度
    		inDegree[edge[0]]++;
    	
    	
        for(int i=0;i<numCourses;i++){
        	if(inDegree[i]==0)//入度为0进行遍历
        		dfs(prerequisites,inDegree,visit,i);
        }
        int[] ret;
        if(ans.size()!=numCourses)
        	return new int[0];
        else{
        	ret = new int[numCourses];
        	int pos=0;
        	for(int i:ans){
        		ret[pos++]=i;
        	}
        	return ret;
        }
    }
    
    private void dfs(int[][] prerequisites,int[] inDegree,boolean[] visit,int pos){//dfs处理每个入度为0的点
    	if(inDegree[pos]!=0 || visit[pos])
    		return;
    	visit[pos] = true;
    	ans.add(pos);
    	for(int[] edge :prerequisites)
    		if(edge[1]==pos){
    			inDegree[edge[0]]--;//和当前点有关系的入度都--
    			dfs(prerequisites,inDegree,visit,edge[0]);//dfs
    		}

    }
}
