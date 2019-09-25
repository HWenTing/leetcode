package T_401_500;

import java.util.TreeSet;

public class T414 {
//	给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
	
//	维护只有三个元素的红黑树TreeSet
	
    public int thirdMax(int[] nums) {

        TreeSet<Integer> set = new TreeSet<>();
        for (Integer elem : nums) {
            set.add(elem);
            if (set.size() > 3) set.remove(set.first());
        }
        
        return set.size() < 3 ? set.last() : set.first();   // set.last() 里面最大的元素
    }
    
    
}
