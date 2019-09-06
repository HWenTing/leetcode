package T_801_900;

public class T897 {

	
//	给定一个树，按中序遍历重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
	
//	使用了额外的空间构造一个新树
//	TreeNode newroot;
//	TreeNode pre;
//    public TreeNode increasingBST(TreeNode root) {
//    	dfs(root);
//    	return newroot;
//    }
//    
////    中序遍历，递归
//    private void dfs(TreeNode root){
//    	if(root==null) return;
//    	dfs(root.left);
//    	if(newroot==null) newroot=new TreeNode(root.val);
//    	if(pre==null)
//    		pre=newroot;//这个地方要注意和newroot连上
//    	else{
//    		pre.right=new TreeNode(root.val);
//    		pre = pre.right;
//    	}
//    	dfs(root.right);
//    }
	
	
//	不使用额外空间，原地操作
	TreeNode newroot;
	TreeNode pre;
    public TreeNode increasingBST(TreeNode root) {
    	dfs(root);
    	return newroot;
    	
    }
    
//    中序遍历，递归
    private void dfs(TreeNode root){
    	if(root==null) return;
    	dfs(root.left);
    	if(newroot==null){
    		newroot=root;
    		newroot.left=null;
    	}
    	
    	if(pre==null)
    		pre=newroot;//这个地方要注意和newroot连上
    	else{
    		pre.right=root;
    		pre = pre.right;
    		pre.left=null;
    	}
    	dfs(root.right);
    }
    
    
}
