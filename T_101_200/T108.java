package T_101_200;

public class T108 {
//	将有序数组转换为高度平衡的bst
//	第一反应是递归，每次存下中间的值，递归左子数组，右子数组
//	一次ac 但是速度和内存都很差，怀疑是Arrays.copyOfRange比较耗费资源
//    public TreeNode sortedArrayToBST(int[] nums) {
//    	int len = nums.length;
//    	if(len==0)return null;
//    	int mid = len/2;
//    	TreeNode root = new TreeNode(nums[mid]);
//    	root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));
//    	root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid+1, len));
//    	return root;
//    }
    
	
//	对上边的方法进行改进，不使用Arrays.copyOfRange，直接规定起始位置和终止位置即可
//	击败了80%速度
    public TreeNode sortedArrayToBST(int[] nums) {
    	return subSortedArrayToBST(nums,0,nums.length);
    }
    
    private TreeNode subSortedArrayToBST(int[] nums,int start,int end){
    	int len = end-start;
    	if(len<=0)return null;
    	int mid = (start+end)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = subSortedArrayToBST(nums, start, mid);
    	root.right = subSortedArrayToBST(nums, mid+1, end);
    	return root;
    }
}
