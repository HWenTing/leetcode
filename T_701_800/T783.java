package T_701_800;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class T783 {

//	给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
//	咋感觉做过。。。中序遍历得到有序数组取相隔最小值
	
	int ans=Integer.MAX_VALUE;
	int before;
	boolean first=true;
    public int minDiffInBST(TreeNode root) {
    	dfs(root);
        return ans;
    }
    
    private void dfs(TreeNode root){
    	if(root==null) return;
    	dfs(root.left);
    	if(first){//来初始化第一个点
    		before=root.val;
    		first=false;
    	}else{
    		ans=Math.min(ans, root.val-before);
    		before = root.val;
    	}
    	dfs(root.right);
    }
}
