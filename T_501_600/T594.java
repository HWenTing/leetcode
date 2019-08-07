package T_501_600;

import java.util.HashMap;
import java.util.Map;

public class T594 {

//	和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。求最长和谐子序列，不一定连续
//	要注意差别正好是1，0不行
//	速度有点慢
	
    public int findLHS(int[] nums) {
    	int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums)
        	map.put(num, map.getOrDefault(num, 0)+1);
        
        for(int num:nums){
        	if(map.containsKey(num+1))
        		max = Math.max(map.get(num)+map.get(num+1), max);
        }
        	
        return max;
    }
}
