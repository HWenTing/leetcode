package T_201_300;

public class T207 {

//	先修课程问题，判断是否可以满足条件
//	拓扑排序
//	击败63%
//	可以再进行优化，将边缘列表转化成邻接链表，并使用队列存储入度位0的点
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	int[] inDegree = new int[numCourses];
    	boolean[] visit = new boolean[numCourses];
    	
    	for(int[] edge :prerequisites)//计算每个点的入度
    		inDegree[edge[0]]++;
    	
    	
        for(int i=0;i<numCourses;i++){
        	if(inDegree[i]==0)//入度为0进行遍历
        		dfs(prerequisites,inDegree,visit,i);
        }
        
        boolean ans =true;
        for(boolean b :visit)//若每个点都被访问过，则满足
        	ans = ans&b;
        return ans;
    }
    
    private void dfs(int[][] prerequisites,int[] inDegree,boolean[] visit,int pos){//dfs处理每个入度为0的点
    	if(inDegree[pos]!=0 || visit[pos])
    		return;
    	visit[pos] = true;
    	for(int[] edge :prerequisites)
    		if(edge[1]==pos){
    			inDegree[edge[0]]--;//和当前点有关系的入度都--
    			dfs(prerequisites,inDegree,visit,edge[0]);//dfs
    		}

    }
    
}
	