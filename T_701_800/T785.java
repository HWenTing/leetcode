package T_701_800;

import java.util.HashSet;

public class T785 {

	
	//判断是否为二分图
//	如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
    
//	击败75%
	private boolean bip=true;
	boolean[] visit ;//判断该节点有没有被处理过
	public boolean isBipartite(int[][] graph) {
        int len = graph.length;
		int[] group = new int[len];
		visit = new boolean[len];
		for(int i=0;i<len;i++){
			fill(graph,group,i);
		}
		
		return bip;
    }
    
	private void fill(int[][] graph,int[] group,int pos){//以某个点为起点，dfs处理
		if(bip==false)
			return;
		
		if(group[pos]==0)//以pos位起点的单独分支，预处理
			group[pos]=1;
		visit[pos]=true;
		
		for(int num:graph[pos]){
			if(group[num]==0)//若没有被分配，设为父节点的相反值
				group[num]=-group[pos];
			if(group[num]==group[pos])//如果与父节点的值相同，则不符合条件
				bip=false;
			if(!visit[num])
				fill(graph,group,num);
		}
		
	}
    
}
