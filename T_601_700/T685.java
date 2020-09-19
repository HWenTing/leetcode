package T_601_700;

public class T685 {

//	在本问题中，有根树指满足以下条件的有向图。该树只有一个根节点，所有其他节点都是该根节点的后继。每一个节点只有一个父节点，除了根节点没有父节点。
//	输入一个有向图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
//	结果图是一个以边组成的二维数组。 每一个边 的元素是一对 [u, v]，用以表示有向图中连接顶点 u 和顶点 v 的边，其中 u 是 v 的一个父节点。
//	返回一条能删除的边，使得剩下的图是有N个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。

//	与T684 区别在是否是有向图   
    
	int[] root;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;
        root = new int[len+1];
        int[] parent = new int[len+1];//记录每个节点的父节点，方便判断是否冲突
        
        for(int i=1;i<=len;i++){//初始化
        	root[i] = i;
        	parent[i] = i;
        }
        
        int conflict = -1;//标记是否冲突
        int cycle = -1;//标记是否存在环
        
        for(int i=0;i<len;i++){
        	int u = edges[i][0];
        	int v = edges[i][1];
        	
        	if(parent[v]!=v)//说明发生了冲突，一个节点拥有两个父节点 。 并且要注意，这里并没有将u和v union起来
        		conflict = i;
        	else{
        		parent[v] = u;
        		if(sameAndconnect(u,v))//说明存在环
        			cycle = i;
        	}
        }

        if(conflict<0)//如果只存在环，那最后一个加入的就是多余的
        	return new int[]{edges[cycle][0],edges[cycle][1]};
        else{
        	if(cycle<0)//如果没有环，那么最后造成冲突的就是多余的
        		return  new int[]{edges[conflict][0],edges[conflict][1]};
        	else//如果存在环，那么最早的注册冲突节点夫父节点的边才是罪魁祸首，要不然就算删掉最后造成冲突的边，还是会形成环
        		return  new int[]{parent[edges[conflict][1]],edges[conflict][1]};
        }
        
        
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
