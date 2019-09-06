package T_801_900;

public class T814 {

//	给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。
//	返回移除了所有不包含 1 的子树的原二叉树。
//	( 节点 X 的子树为 X 本身，以及所有 X 的后代。)
	
	
//	递归处理吧，左子树全为0则置空，右子树全为0则置空，返回是否当前树全为0
    public TreeNode pruneTree(TreeNode root) {
    	if(root==null || dfs(root)) return null;
    	return root;
    }
    
    private boolean dfs(TreeNode root){
    	if(root==null) return true;
    	boolean left = dfs(root.left);
    	boolean right = dfs(root.right);
    	if(left)//左边是否为空
    		root.left=null;
    	if(right)//右边是否为空
    		root.right=null;
    	
    	return left&&right&&root.val==0;//该分支是否全为0
    }
}
