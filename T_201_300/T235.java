package T_201_300;

public class T235 {

//	二叉搜索树求最近公共祖先
//
//	有一种比较复杂的想法，首先找到一条到某个节点的路径，用stack存起来，然后看路径中的哪个节点可以找到另一个节点，返回即可
//	奇慢。。。击败了5%.....
//	(好吧，其实这种方法对所有的树都管用，特殊处理二叉搜索树有更好的方法)
//	....T236用这个方法解决就可以。。。击败60%还可以
	
	
//    private Queue<TreeNode> st = new LinkedList<TreeNode>();
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        findpath(root,p);
//       // System.out.println(11111);
//        while(!st.isEmpty()){
//            TreeNode temp = st.poll();
//            if(isfind(temp,q)){
//                return temp;
//            }
//        }
//        return null;
//        
//    }
//    
//    private boolean isfind(TreeNode root,TreeNode q ){
//        if(root==null)
//            return false;
//        if(root==q){
//            return true;            
//        }
//        
//        if(isfind(root.left,q) || isfind(root.right,q)){
//            return true;
//        }else{
//            return false;
//        }
//    }
//    
//    private boolean findpath(TreeNode root, TreeNode p){
//        if(root==null)
//            return false;
//        if(root==p){
//            st.add(root);
//            return true;
//            
//        }
//        
//        if(findpath(root.left,p) || findpath(root.right,p)){
//            st.add(root);
//            return true;
//        }else{
//            return false;
//        }
//    }
	
	
//	对bst来说，只要确定root 在q和p之间即可
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val<p.val && root.val < q.val)
            return lowestCommonAncestor(root.right,p,q);
        if(root.val>p.val && root.val > q.val)
            return lowestCommonAncestor(root.left,p,q);
        return root;
    }
    
}
