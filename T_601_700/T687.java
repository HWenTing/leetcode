package T_601_700;


public class T687 {
    
    // 递归调用，要把递归的起始部分分开
//	第一次交 有很多重复计算的步骤
//	第二次通过每个节点只算了一次
	
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
        
        
        int left=0;
        int right=0;
        if(root.left != null && root.val==root.left.val)
            left+=sublong(root.left)+1;
        if(root.right != null && root.val==root.right.val)
            right+=sublong(root.right)+1;
        
        return Math.max(left+right,Math.max(longestUnivaluePath(root.left),longestUnivaluePath(root.right)));
    }
    
    private int sublong(TreeNode root){

        int left=0;
        int right=0;
        if(root.left != null && root.val==root.left.val)
            left+=sublong(root.left)+1;
        if(root.right != null && root.val==root.right.val)
            right+=sublong(root.right)+1;
        return Math.max(left,right);
        
    }
}
