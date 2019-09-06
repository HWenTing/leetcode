package T_901_1000;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class T938 {

//	给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
//	二叉搜索树保证具有唯一的值。
	
	int sum=0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null) return 0;
    	dfs(root,L,R);
    	return sum;
    }
    
    private void dfs(TreeNode root, int L, int R){
    	if(root==null ) return;
    	if(root.val<L){
    		dfs(root.right,L,R);
    	}else if(root.val>R){
    		dfs(root.left,L,R);
    	}else{
    		sum+=root.val;
    		dfs(root.left,L,R);
    		dfs(root.right,L,R);
    	}
    }
}







