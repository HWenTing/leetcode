package T_401_500;

public class T404 {

//	左叶子之和
	
	private int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
    	if(root==null)
    		return 0;
    	if (isLeaf(root.left)) 
    		return root.left.val + sumOfLeftLeaves(root.right); 
    	return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    
    private boolean isLeaf(TreeNode node){ //判断是不是叶节点
    	if (node == null) 
    		return false; 
    	return node.left == null && node.right == null; 
    }
}
