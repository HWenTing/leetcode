package T_101_200;

import java.util.Arrays;

public class T169 {
	
//	求出现次数大于n/2的数。先排序在取中间值，复杂度是nlogn
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length/2];
//    }
	
//	摩尔投票法，同加异减 , 复杂度 n
    public int majorityElement(int[] nums) {
    	int ans=nums[0];
    	int count=0;
    	for(int num:nums){
    		if(count==0){
    			ans = num;
    			count++;
    		}else{
        		if(num==ans)
        			count++;
        		else
        			count--;
    		}
    	}
    	return ans;
    }

}
