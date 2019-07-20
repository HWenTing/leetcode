package T_101_200;
class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class T104 {
	int max=0;
    int length=0;
    private void hasnext(TreeNode root){
        if(root != null){
            length++;
            if(max<length){
                max = length;
            }
            hasnext(root.left);
            hasnext(root.right);
            length--;
        }        
    }
    public int maxDepth(TreeNode root) {
        hasnext(root);
        return max;
    }
}
