package T_101_200;

public class T162 {

//	峰值元素是指其值大于左右相邻值的元素。
//	给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
//	数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
//	 nums[-1] = nums[n] = -∞。

//	你的解法应该是 O(logN) 时间复杂度的。
	
//	看到log想二分，因为两端都为-∞，所以对中间节点来说，哪边大，峰值一定在哪边
    public int findPeakElement(int[] nums) {
        
    	int left=0;
    	int right = nums.length-1;
    	int mid=0;
    	while(left<right){
    		mid = (left+right)/2;
    		if(nums[mid]<nums[mid+1]){
    			left = mid+1;
    		}else{
    			right = mid; 
    		}
    	}
    	return left;
    }
    
}






