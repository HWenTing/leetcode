package T_201_300;

public class T209 {

	
//	给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
//	双指针 若当前和小于s，right++，反之left++
    public int minSubArrayLen2(int s, int[] nums) {
    	if(nums.length==0) return 0;
        int left=0;
        int right=0;
        int cursum=nums[0];
        int ans=nums.length+1;
        while(right<nums.length){
        	if(cursum<s){
        		right++;
        		if(right<nums.length)
        			cursum+=nums[right];
        	}else{
        		ans = Math.min(ans, right-left+1);
        		cursum-=nums[left];
        		left++;
        		if(ans==1) return 1;
        	}
        }
        return ans==nums.length+1?0:ans;
        
    }
    
    

    
    
    
    
}
