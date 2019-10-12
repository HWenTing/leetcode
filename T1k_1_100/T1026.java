package T1k_1_100;

public class T1026 {

//	求存在祖先关系的两节点差的最大值
	
//	每个节点返回以此节点为根的最大值最小值
//	时间击败18%，空间击败100%
//	从上往下递归，然后从下返回值，慢一些，下边的方法直接从上到下
//	private int ans=0;
//    public int maxAncestorDiff(TreeNode root) {
//    	dfs(root);
//    	return ans;
//    }
//    
//    private int[] dfs(TreeNode root){//[最小，最大]
//    	
//    	if(root.left==null && root.right==null) return new int[]{root.val,root.val}; 
//    	
//    	int min,max;
//    	if(root.left==null && root.right!=null){
//    		int[] right = dfs(root.right);
//    		min = right[0];
//    		max = right[1];
//    	}else if(root.left!=null && root.right==null){
//    		int[] left = dfs(root.left);
//    		min = left[0];
//    		max = left[1];
//    	}else{
//        	int[] left = root.left==null?new int[]{root.val,root.val}:dfs(root.left);
//        	int[] right = root.right==null?new int[]{root.val,root.val}: dfs(root.right);
//        	min = Math.min(left[0], right[0]);
//        	max = Math.max(left[1], right[1]);
//    	}
//    	
//    	int temp = Math.max(Math.abs(root.val-min), Math.abs(root.val-max));
//    	ans = Math.max(ans, temp);
//    	
//    	return new int[]{Math.min(min, root.val),Math.max(max, root.val)};
//    }
	
	
//	从上到下一气呵成
//	时间99% 空间100%
    int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        found(root,root.val,root.val);
        return max;
    }
    
    public void found(TreeNode root,int value_max,int value_min){
        if(root == null)
            return;
        int count_max = Math.max(value_max,root.val);
        int count_min = Math.min(value_min,root.val);
        max = Math.max(max,Math.max(Math.abs(count_max-root.val),Math.abs(count_min-root.val)));
        found(root.left,count_max,count_min);
        found(root.right,count_max,count_min);
    }
    
}
