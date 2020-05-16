package SwordToOffer;

public class T26 {

//	输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//	B是A的子结构， 即 A中有出现和B相同的结构和节点值。
	
	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}

//	递归呗
    public boolean isSubStructure(TreeNode A, TreeNode B) {
    	if(A==null || B==null) return false;
    	return same(A,B)||isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    
    private boolean same(TreeNode A, TreeNode B){
    	if(B==null) return true;
    	else if(A==null) return false;
    	
    	return  A.val==B.val && same(A.left,B.left) && same(A.right,B.right);
    }
}
