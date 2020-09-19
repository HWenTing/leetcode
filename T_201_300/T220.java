package T_201_300;

import java.util.HashMap;

public class T220 {

//	在整数数组 nums 中，是否存在两个下标 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值小于等于 t ，
//	且满足 i 和 j 的差的绝对值也小于等于 ķ 。
//
//	如果存在则返回 true，不存在返回 false。
//  此题和T219类似，引入了箱子的概念  0号箱子包含值为[0,t]内的元素
	
	
	private long getId(long num,long base){//返回num所属于的箱子序号 对于负数 比如num=-5 base-5，则分到序号-1箱子
		return num>=0?num/base:(num+1)/base-1;
	}
	
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if (t < 0) return false;
    	HashMap<Long,Long> map = new HashMap<>();//存放箱子序号与数字
    	long base = t+1;
    	
    	for(int i=0;i<nums.length;i++){
    		long id = getId(nums[i],base);
    		
    		if(map.containsKey(id))//在同一个序号的箱子里的数字差肯定小于t 直接返回true
    			return true;
    		if((map.containsKey(id-1) && Math.abs(nums[i]-map.get(id-1))<=t) ||
    				(map.containsKey(id+1) && Math.abs(nums[i]-map.get(id+1))<=t) )//在隔壁箱子里,需要判断差是不是在t以内
    			return true;
    		
    		map.put(id, (long)nums[i]);
    		if(i>=k)//维护hashmap中的键是在k距离内
    			map.remove(getId(nums[i-k],base));
    	}
    	return false;
    }
    
    
}
