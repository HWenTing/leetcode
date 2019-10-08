package T_601_700;

public class T643 {
//	给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
	
//	滑动窗口算呗
    public double findMaxAverage(int[] nums, int k) {
    	int ans=0;
        for(int i=0;i<k;i++){
        	ans+=nums[i];
        }

        int before=ans;
        for(int i=k;i<nums.length;i++){
        	before = before-nums[i-k]+nums[i];
        	ans = Math.max(ans, before);
        }
        
        return ans/(double)k;
    }
    
}
