package T_501_600;



public class T572 {

//	判断一个树是否为另一个的子树
//	第一想法是递归，如果s与t当前结点值相同，递归判断其左右子树
//	还是双递归
    public boolean isSubtree(TreeNode s, TreeNode t) {
    	if (s == null) return false;	
    	return recursion(s,t) || isSubtree(s.left,t)||isSubtree(s.right,t);
    }
    
    private boolean recursion(TreeNode s, TreeNode t){//以s和t为根节点的树是否相同

        if(t==null && s==null)
        	return true;
        if(s==null || t==null)
        	return false;
        if(s.val!=t.val){
        	return false;
        }
        return recursion(s.left,t.left) && recursion(s.right,t.right);
    }
    

//	下边没有通过。。。但是我不知道哪里错了。。也不想再看了
//	private boolean issub=false; 
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        if (s == null) return false;	
//    	recursion(s,t);
//    	isSubtree(s.left,t);
//    	isSubtree(s.right,t);
//    	return issub;
//    }
//    private void recursion(TreeNode s, TreeNode t){
//        if(t==null && s==null){
//        	issub =true;
//        	return;
//        }
//        if(s==null || t==null){
//        	issub =false;
//        	return;
//        }
//        if(s.val==t.val){
//        	recursion(s.left,t.left);
//        	recursion(s.right,t.right);
//        }
//    }
}
