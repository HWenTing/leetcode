package T_601_700;

public class T654 {

//	给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//	二叉树的根是数组中的最大元素。
//	左子树是通过数组中最大值左边部分构造出的最大二叉树。
//	右子树是通过数组中最大值右边部分构造出的最大二叉树。

	
//	递归构造子树，
//	每次寻找小区间最大值，感觉很慢
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums,0,nums.length);
    }
    
    private TreeNode dfs(int[] nums,int start,int end){
    	if(end-start==0) return null;
    	else if(end-start==1)
    		return new TreeNode(nums[start]);
    	
    	int maxindex=start;
    	for(int i=start+1;i<end;i++){
    		if(nums[maxindex]<nums[i])
    			maxindex=i;
    	}
    	
    	TreeNode root = new TreeNode(nums[maxindex]);
    	root.left = dfs(nums,start,maxindex);
    	root.right = dfs(nums,maxindex+1,end);
    	return root;
    }
    
}
