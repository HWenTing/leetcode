package T_1_100;

import java.util.*;

public class T18 {
	
    public static List<List<Integer>> fourSum(int[] nums, int target) {
    	
    	List<List<Integer>> ans = new ArrayList<>();
    	if(nums.length<4){
    		return ans;
    	}
    	Arrays.sort(nums);
    	int len = nums.length;
    	int befor=nums[0]+1;
    	for(int tarpos = 0;tarpos<len-3;tarpos++){
    		int tar = nums[tarpos];
    		if(tar==befor){
    			continue;
    		}
    		
    		for (int i = tarpos+1; i < nums.length - 2; i++) {
	            if (i == tarpos+1 || (i > 0 && nums[i] != nums[i - 1])) { 
	 
	                int l = i + 1, r = nums.length - 1, sum = target - tar - nums[i];
	                while (l < r) {
	                    if (nums[l] + nums[r] == sum) {
	                        ans.add(Arrays.asList(tar,nums[i], nums[l], nums[r]));
	                        while (l < r && nums[l] == nums[l + 1]) l++;
	                        while (l < r && nums[r] == nums[r - 1]) r--;
	                        l++;
	                        r--;
	                    } else if (nums[l] + nums[r] < sum) {
	                        while (l < r && nums[l] == nums[l + 1]) l++;   
	                        l++;
	                    } else {
	                        while (l < r && nums[r] == nums[r - 1]) r--;
	                        r--;
	                    }
	                }
	            }
	        }
    		
    		befor = tar;
    	
    	}

    	return ans;
    }
    
    public static void main(String []args){
		int[] aa = {0,0,0,0};
		
		System.out.println(fourSum(aa,0));
	}
}
