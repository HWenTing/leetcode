package T_201_300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T207 {

//	你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
//	在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
//	给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

	
//	先修课程问题，判断是否可以满足条件
//	拓扑排序
//	击败14%
//	可以再进行优化，将边缘列表转化成邻接链表，并使用队列存储入度为0的点
//	private int count;
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//    	int[] inDegree = new int[numCourses];
//    	boolean[] visit = new boolean[numCourses];
//    	count = 0;
//    	
//    	for(int[] edge :prerequisites)//计算每个点的入度
//    		inDegree[edge[0]]++;
//    	
//    	
//        for(int i=0;i<numCourses;i++){
//        	if(inDegree[i]==0)//入度为0进行遍历
//        		dfs(prerequisites,inDegree,visit,i);
//        }
//        
//        return count==numCourses;
//    }
//    
//    private void dfs(int[][] prerequisites,int[] inDegree,boolean[] visit,int pos){//dfs处理每个入度为0的点
//    	if(inDegree[pos]!=0 || visit[pos])
//    		return;
//    	visit[pos] = true;
//    	count++;
//    	for(int[] edge :prerequisites)
//    		if(edge[1]==pos){
//    			inDegree[edge[0]]--;//和当前点有关系的入度都--
//    			dfs(prerequisites,inDegree,visit,edge[0]);//dfs
//    		}
//    }
    
//	优化一下
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegress = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<>());
        }
        for(int[] cp : prerequisites){
            indegress[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(indegress[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for(int cur : adjacency.get(pre)){
                indegress[cur]--;
                if(indegress[cur] == 0){
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }
    
}
	