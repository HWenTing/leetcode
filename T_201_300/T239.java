package T_201_300;

public class T239 {

//	给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//	返回滑动窗口中的最大值。

	
//	动态规划 
//	将输入数组分割成有 k 个元素的块。
//	left[j] 是从块的开始到下标 j 最大的元素，方向 左->右。
//	right[j] 是从块的结尾到下标 j 最大的元素，方向 右->左
	
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums.length*k==0 || k>nums.length) return new int[0];

    	int[] left = new int[nums.length];
    	int[] right = new int[nums.length];
    	left[0] = nums[0];
    	right[nums.length-1] = nums[nums.length-1];
    	
    	for(int i=1;i<nums.length;i++){
    		
    		if(i%k==0)
    			left[i] = nums[i];
    		else
    			left[i] = Math.max(left[i-1], nums[i]);
    		
    		int j=nums.length-i-1;
    		if(j%k==0)
    			right[j] = nums[j];    		
    		else
    			right[j] = Math.max(right[j+1], nums[j]);
    			
    	}
    	
    	int[] ans = new int[nums.length-k+1];
    	for(int i=0;i<nums.length-k+1;i++){
    		ans[i] = Math.max(left[i+k-1], right[i]);
    	}
    	return ans;
    }
    
}
