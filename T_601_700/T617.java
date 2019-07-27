package T_601_700;

class TreeNode {
    int val;     
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class T617 {

//	二叉树重叠
//	考虑将t2贴到t1上
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
        	return t1;
        }else if(t1 == null && t2 != null){
        	t1 = t2;
        	return t1;
        }else if(t1!=null && t2==null){
        	return t1;
        }else{
            t1.val=t1.val+t2.val;
            t1.left = mergeTrees(t1.left,t2.left);//这个地方要再赋回去，接上
            t1.right = mergeTrees(t1.right,t2.right);
            return t1;
        }
    }
    
    
    
}
