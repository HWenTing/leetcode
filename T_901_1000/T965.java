package T_901_1000;

public class T965 {

//	如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。判断是否为单值二叉树
	
//	dfs
    public boolean isUnivalTree(TreeNode root) {
    	return(dfs(root,root.val));
    }
    
    private boolean dfs(TreeNode root,int k){
    	if(root==null) return true;
    	if(root.val!=k) return false;
    	return dfs(root.left,k)&&dfs(root.right,k);
    }
}
