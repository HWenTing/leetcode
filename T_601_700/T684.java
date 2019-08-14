package T_601_700;

public class T684 {

//	并查集解决
//	击败100%   哈哈哈
	int[] root;
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        root = new int[len+1];
        
        for(int i=1;i<len;i++){//初始化
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
