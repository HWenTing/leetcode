package T_201_300;

import java.util.Arrays;

public class T213 {
//竟然过了。。。。在198的基础上改的，两头不能同时取到，那么就当成头不存在或者尾部不存在，然后求最大值
	
    public int rob(int[] nums) {
    	if(nums.length==0)
    		return 0;
    	if(nums.length==1)
    		return nums[0];
        int noleft = subrob(Arrays.copyOfRange(nums, 1, nums.length));
        int noright = subrob(Arrays.copyOfRange(nums, 0, nums.length-1));
        int max = Math.max(noleft, noright);
        return max;
        
    }
    
    public int subrob(int[] nums) {
    	int n = nums.length;
    	if(n==0)
    		return 0;
    	if(n==1)
    		return nums[0];
    	int pre2 = nums[0];
    	int pre1 = Math.max(nums[0], nums[1]);
    	int cur = pre1;
    	for(int i=2;i<n;i++){
    		
    		cur = Math.max(pre1, pre2+nums[i]);
    		pre2 = pre1;
    		pre1 = cur;
    	}
    	return cur;
    }
	public static void main(String[] args) {
		T213 t = new T213();
		System.out.println(t.rob(new int[]{2,3,2}));
	}
}
