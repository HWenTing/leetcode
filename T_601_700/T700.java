package T_601_700;

public class T700 {

//	给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
	
//	递归
	
//	没注意是二叉搜索树。。下边的方法适用于任何
//    public TreeNode searchBST(TreeNode root, int val) {
//    	if(root==null) return null;
//        if(root.val==val)
//        	return root;
//        
//        TreeNode left=searchBST(root.left,val);
//        TreeNode right=searchBST(root.right,val);
//        return left==null?right:left;
//    }
	
//	适用于二叉搜索树
    public TreeNode searchBST(TreeNode root, int val) {
    	if(root==null) return null;
        if(root.val==val)
        	return root;
        if(root.val<val){//分支搜索
        	return searchBST(root.right,val);
        }else{
        	return searchBST(root.left,val);
        }
    }
    
}
