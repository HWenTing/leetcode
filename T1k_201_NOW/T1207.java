package T1k_201_NOW;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class T1207 {

//	给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
//	如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
	
//	哈希表 数组更快
    public boolean uniqueOccurrences(int[] arr) {
        
        Map<Integer, Integer> counter = new HashMap<>();
        for (int elem : arr)
            counter.put(elem, counter.getOrDefault(elem, 0) + 1);
        
        return counter.size() == new HashSet<Integer>(counter.values()).size();
    }
    
}
