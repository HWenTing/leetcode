package SwordToOffer;

public class T42 {

//	输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//	要求时间复杂度为O(n)。
	
    public int maxSubArray(int[] nums) {
    	if(nums.length==0) return 0;
    	
    	int max =  nums[0];
    	int cur = nums[0];
    	
    	for(int i=1;i<nums.length;i++){
    		cur = Math.max(0, cur)+nums[i];
    		max = Math.max(max, cur);
    	}
    	return max;
    	
    }
    
}
