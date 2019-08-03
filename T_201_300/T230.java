package T_201_300;

public class T230 {

//	求解bst的第k小元素
//	维护最小值min和记述器cnt；
//	根据左中右的顺序处理计数即可
//
//	第k大 应该根据右中左的顺序即可
	
    int cnt=0;
    int min;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return min;
    }
    
    private void dfs(TreeNode root,int k){
        if(root == null || cnt>k)
            return;
        dfs(root.left,k);
        cnt++;
        if(cnt==k){
            min=root.val;
            return ;
        }
        dfs(root.right,k);
    
    }
    
}
