package T_601_700;

public class T674 {

//	给定一个未经排序的整数数组，找到最长且连续的的递增序列。
	
    public int findLengthOfLCIS(int[] nums) {
    	if(nums.length<2) return nums.length;
    	int ans = 1;
    	int cnt=1;
    	for(int i=1;i<nums.length;i++){
    		if(nums[i]>nums[i-1]){
    			cnt++;
    		}else{
    			ans=Math.max(ans, cnt);
    			cnt=1;
    		}
    	}
    	return Math.max(ans, cnt);
    }
    
}
