package T_1001;

public class T1145 {

	
//	 二叉树着色游戏
	
//	感觉像判子树大小的关系
//	if (size(root.left)>n/2 || size(root.right)>n/2 || size(root)<=n/2) return true;
//	时间击败99%，空间100%
	
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    	TreeNode num1 = find(root,x);
    	int left = size(num1.left);
    	int right =  size(num1.right);

    	if (left>n/2 || right>n/2 || (left+1+right)<=n/2) return true;
    	return false;
    }
    
    //找到x节点
    private TreeNode find(TreeNode root,int x){
    	if(root==null) return null;
    	if(root.val==x) return root;
    	TreeNode left = find(root.left,x);
    	TreeNode right = find(root.right,x);
    	return left==null?right:left;
    }
    
//    返回树的大小
    private int size(TreeNode root){
    	if(root==null) return 0;
    	return 1+size(root.left)+size(root.right);
    }
}
