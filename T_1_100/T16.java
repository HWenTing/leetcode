package T_1_100;

import java.util.Arrays;

public class T16 {
	
//	给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
//	找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

//	固定住一个 对另外两个双指针
    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);//排序
    	int t=(nums[0]+nums[1]+nums[2]);
    	
    	for (int i = 0; i < nums.length - 2; i++) {
    		if(i>0 && nums[i] == nums[i - 1]) continue;//剪枝

			int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (target  == nums[i]+nums[l] + nums[r]) {
                    return target;
                } else {
                	if(Math.abs(target-nums[i]-nums[l] - nums[r])<Math.abs(t-target))
                		t = nums[i]+nums[l] + nums[r];
                	
                	//跳过重复的
                	if(nums[i]+nums[l] + nums[r] <target){
                		while (l < r && nums[l] == nums[l + 1]) l++;   
                		l++;
                	}else{
                		while (l < r && nums[r] == nums[r - 1]) r--;
                		r--;
                	}
                }
            }
        }
        return t;
    	
    }
    
}
