package T_201_300;


class TreeNode {
    int val;     
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


public class T226 {

//	左右反转二叉树
//	递归 ,左右交替赋值，要注意前后的影响
//	root.left =invertTree(root.right);
//	root.right =invertTree(root.left);
	
    public TreeNode invertTree(TreeNode root) {
    	if(root==null)
    		return root;
    	TreeNode left = root.left;
    	root.left =invertTree(root.right);
    	root.right =invertTree(left);//注意前后的影响,小心被覆盖
    	return root;
    }
    
}
