package T_201_300;

import java.util.LinkedList;
import java.util.List;

public class T229 {

	
//	给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素
//	要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
	
//	改进摩尔投票法
    public List<Integer> majorityElement(int[] nums) {
    	List<Integer> ans = new LinkedList<>();
        if(nums==null || nums.length==0)
        	return ans;
    	int major1 = nums[0];
    	int major2 = nums[0];
    	int cnt1 = 0;
    	int cnt2 = 0;
//    	先用摩尔投票选出两个，但是不一定满足大于1/3
//    	如果存在大于1/3的元素，存在major1或major2中
//    	如果不存在大于1/3的元素，major1、major2中也有东西，但是无意义，代表的也不是最多的两个元素，这个要注意
    	for(int num:nums){
    		if(num==major1){
    			cnt1++;
    		}else if(num==major2){
    			cnt2++;
    		}else if(cnt1==0){//更换
    			major1 = num;
    			cnt1++;
    		}else if(cnt2==0){
    			major2 = num;
    			cnt2++;
    		}else{
    			cnt1--;
    			cnt2--;
    		}
    	}
    	
//    	检查是否多与1/3
    	cnt1=0;
    	cnt2=0;

    	for(int num:nums){
    		if(num==major1)
    			cnt1++;
    		else if(num==major2)
    			cnt2++;
    	}
    	if(cnt1>nums.length/3)
    		ans.add(major1);
    	if(cnt2>nums.length/3)
    		ans.add(major2);
    	return ans;
    }
    
}
