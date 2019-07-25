package T_601_700;

import java.util.Arrays;

public class T628 {

//	先找到最大的前三个数和最小的后两个数
//	考虑到可能存在负数，因此
//	取max（max1*max2*max3，min1*min2*max1）
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[nums.length-1], nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3]);
    }
    
}
