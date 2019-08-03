package T_201_300;

import java.util.LinkedList;
import java.util.Queue;

public class T236 {

//	首先找到一条到某个节点的路径，用stack存起来，然后看路径中的哪个节点可以找到另一个节点，返回即可
	
    private Queue<TreeNode> st = new LinkedList<TreeNode>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findpath(root,p);
       // System.out.println(11111);
        while(!st.isEmpty()){
            TreeNode temp = st.poll();
            if(isfind(temp,q)){
                return temp;
            }
        }
        return null;
        
    }
    
    private boolean isfind(TreeNode root,TreeNode q ){
        if(root==null)
            return false;
        if(root==q){
            return true;            
        }
        
        if(isfind(root.left,q) || isfind(root.right,q)){
            return true;
        }else{
            return false;
        }
    }
    
    private boolean findpath(TreeNode root, TreeNode p){
        if(root==null)
            return false;
        if(root==p){
            st.add(root);
            return true;
            
        }
        
        if(findpath(root.left,p) || findpath(root.right,p)){
            st.add(root);
            return true;
        }else{
            return false;
        }
    }

}
