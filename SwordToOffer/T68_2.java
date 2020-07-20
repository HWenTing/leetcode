package SwordToOffer;


public class T68_2 {

	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	//对于二叉树的通用方法：分别判断左右分支是否含有p或q，然后根据当前节点进行判断
	private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	find(root,p,q);
    	return ans;
    }
    
    private boolean find(TreeNode root, TreeNode p, TreeNode q){
    	if(ans!=null || root==null) return false;
    	
    	boolean left = find(root.left,p,q);
    	boolean right =  find(root.right,p,q);
    	boolean cur = root.val==p.val || root.val==q.val;
    	if((left&&right) || (cur && (left|| right))){
    		ans = root;
    	}
    	return left||right||cur;
    }
    
}
