package T_601_700;

public class T669 {

//	修剪二叉搜索树
//	递归呗
	
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null)
            return root;
        if(root.val>R){
            
            return trimBST(root.left,L,R);    
        }else if(root.val<L){
            
            return trimBST(root.right,L,R);
        }else{
            root.left = trimBST(root.left,L,R);
            root.right = trimBST(root.right,L,R);
            return root;
        }
        
        
    }
    
}
