package T_201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T219 {

//	给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

//	用hashmap简单解决
//	击败75%
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//value只存最后的元素就好了
    	for(int i = 0; i < nums.length; i++){
    		if(map.containsKey(nums[i]) && map.get(nums[i])+k>=i)
    			return true;
    		map.put(nums[i], i);
    	}
    	return false;
    }
    
    
}
