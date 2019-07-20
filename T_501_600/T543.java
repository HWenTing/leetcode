package T_501_600;


class TreeNode {
    int val;     
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class T543 {
//	递归咯，
	public static int diameterOfBinaryTree(TreeNode root) {
		if(root!=null){
			return Math.max(dis(root.left)+dis(root.right), Math.max(diameterOfBinaryTree(root.right),diameterOfBinaryTree(root.left)));			
		}
		return 0;
    }
	public static int dis(TreeNode root){
		if(root!=null){
			return Math.max(dis(root.left)+1, dis(root.right)+1);			
		}
		return 0;
	}
	public static void main(String [] args){
    	TreeNode s = new TreeNode(1);

    	
    	TreeNode temp1 = new TreeNode(2);
    	s.left = temp1;
    	TreeNode temp2 = new TreeNode(3);
    	s.right = temp2;
    	TreeNode temp3 = new TreeNode(4);
    	temp1.left =  temp3;
    	TreeNode temp4 = new TreeNode(5);
    	temp1.right =  temp4;

    	
		System.out.println(diameterOfBinaryTree(s));
	 }
}
