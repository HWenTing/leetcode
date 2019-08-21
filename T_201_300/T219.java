package T_201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T219 {

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
