package T_701_800;

public class T701 {

//	给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
    
//	递归插入
//	哦豁一遍ac
	public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        if(root.val<val){
        	root.right = insertIntoBST(root.right,val);
        }else{
        	root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
    
}
