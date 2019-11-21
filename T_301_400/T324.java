package T_301_400;

import java.util.Arrays;

public class T324 {
	
//	给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
//	你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗
	
	
//	时间复杂度O(nlogn), 空间复杂度O(n)
//	先排序，然后倒叙，然后插入
//	[1,1,2,2,3,3] -->[1,1,2] [2,3,3] -->[2,1,1] [3,3,2] -->[2,3,1,3,1,2]
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] temp = Arrays.copyOf(nums, nums.length);
        int mid = (nums.length-1)/2;
        for(int i=0;i<=mid;i++){
        	nums[i*2] = temp[mid-i];
        }
        for(int i=mid+1;i<nums.length;i++){
        	nums[2*(i-mid)-1] = temp[nums.length-(i-mid)];
        }
    }
    
//    时间复杂度O(n), 空间复杂度O(n)
//    不需要要排序，只需要找到中位数，然后将中位数放在数组中间，然后将数组分为两半，按照上边的方法继续即可
//    中位数用快速选择算法，将中位数放在数组中间用3-way-partition算法（类似于荷兰国旗问题），时间复杂度都是O(n)
    
    
//    想要实现空间复杂度O(1),需要用虚拟地址方法，类似reshuffle，根据下标计算交换到的位置
    
    
}
