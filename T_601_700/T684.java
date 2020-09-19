package T_601_700;

public class T684 {

//	在本问题中, 树指的是一个连通且无环的无向图。
//	输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
//	结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
//	返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。

	
//	并查集解决
//	击败100%  哈哈哈
	int[] root;
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        root = new int[len+1];
        
        for(int i=1;i<=len;i++){//初始化
        	root[i] = i;
        }
        
        int[] ans = new int[2];
        for(int[] edge:edges){
        	if(sameAndconnect(edge[0],edge[1])){//判断两个端点是否相连
        		ans[0] = Math.min(edge[0],edge[1]);
        		ans[1] = Math.max(edge[0],edge[1]);
        	}
        }
        return ans;
    }
    
    private boolean sameAndconnect(int l,int r){//判断两个端点是否相连，相连返回true，否则连起来
    	while(l!=root[l]){//找到l的根节点
    		l = root[l];
    	}    	
    	while(r!=root[r]){//找到r的根节点
    		r = root[r];
    	}
    	
    	if(l == r)
    		return true;
    	
    	root[r] = l;
    	return false;
    }
    
    
}
