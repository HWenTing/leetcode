package T_401_500;

public class T404 {

//	左叶子之和
	private int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
    	if(root==null)
    		return 0;
    	hasleft(root);
        return sum;
    }
    private void hasleft(TreeNode root){
    	
    }
}
