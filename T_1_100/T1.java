package T_1_100;

import java.util.HashMap;

public class T1 {
	
//	求哪两数和等于target
//	第一次暴力循环做的
//	int[] twoSum(int[] nums, int target) {
//		int temp[]={0,0};
//        for(int i =0;i<nums.length-1;i++){
//        	for(int j = i+1;j<nums.length;j++){
//        		if(nums[i]+nums[j]==target){	
//        			temp[0] = i;
//        			temp[1] = j;
//        		}
//        	}
//        }
//        return temp;
//    }

//	做用 HashMap 存储数组元素和索引的映射，在访问到 nums[i] 时，判断 HashMap 中是否存在 target - nums[i]，如
//	果存在说明 target - nums[i] 所在的索引和 i 就是要找的两个数。该方法的时间复杂度为 O(N)，空间复杂度为
//	O(N)，使用空间来换取时间。
	
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();//存放nums元素
        int len = nums.length;
        
        for(int i=0;i<len;i++){
        	if(hashmap.containsKey(target-nums[i]))
        		return new int[]{hashmap.get(target-nums[i]),i};
        	else
        		hashmap.put(nums[i], i);
        }
        return null;
    }
}
