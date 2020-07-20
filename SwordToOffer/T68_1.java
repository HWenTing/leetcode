package SwordToOffer;


public class T68_1 {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
//	给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。同T235
	
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
    
//	对bst来说，只要确定root 在q和p之间即可
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root.val<p.val && root.val < q.val)
//            return lowestCommonAncestor(root.right,p,q);
//        if(root.val>p.val && root.val > q.val)
//            return lowestCommonAncestor(root.left,p,q);
//        return root;
//    }
}
