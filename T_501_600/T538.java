package T_501_600;

public class T538 {

//	把二叉搜索树转换成累加树
//
//	思路1：类似T230，维护subsum，根据右中左来遍历处理
	
    private int subsum=0;
    public TreeNode convertBST(TreeNode root) {
        change(root);
        return root;
    }
    
    private void change(TreeNode root){
        if(root==null)
            return;
        change(root.right);
        
        root.val+=subsum;
        subsum=root.val;
        change(root.left);
        
    }
}
