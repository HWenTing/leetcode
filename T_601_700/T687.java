class T687 {
    
    // 
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
