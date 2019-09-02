package T_1_100;

public class T100 {

//	给定两个二叉树，编写一个函数来检验它们是否相同。
//	递归处理，较为简单
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null &&q==null)
        	return true;
        if(p==null || q==null)
        	return false;
        
        if(p.val!=q.val)
        	return false;
        
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        
    }
    
}
