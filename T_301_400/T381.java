package T_301_400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class T381 {
//	设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
//	注意: 允许出现重复元素。
//	insert(val)：向集合中插入元素 val。
//	remove(val)：当 val 存在时，从集合中移除一个 val。
//	getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
	
//	想要O(1)随机取元素，很容易想到在数组中随机取下标，所以要维护一个数组，当删除元素时，使用最后一个元素补上空缺
	class RandomizedCollection {
		
		private List<Integer> nums;
		private Map<Integer,Set<Integer>> idx;
		private int len;
	    /** Initialize your data structure here. */
	    public RandomizedCollection() {
	    	nums = new LinkedList<>();
	    	idx = new HashMap<>();
	    	len = 0;
	    }
	    
	    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	    public boolean insert(int val) {
	    	nums.add(val);
	    	if(!idx.containsKey(val))
	    		idx.put(val, new HashSet<>());
	    	idx.get(val).add(len);	
    		len++;
    		return idx.get(val).size()==1;
	    }
	    
	    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
	    public boolean remove(int val) {
	    	if(!idx.containsKey(val) || idx.get(val).size()==0)
	    		return false;
	    	
	    	if(nums.get(len-1)==val){
	    		idx.get(val).remove(--len);
	    		nums.remove(len);
	    		return true;
	    	}
	    	
	    	int rm = idx.get(val).iterator().next();//要删除的节点索引
	    	idx.get(val).remove(rm); //删除原来节点索引
	    	
	    	nums.set(rm, nums.get(--len)); //将最后节点填回来
	    	int last = nums.get(len); //最后节点的值
	    	
	    	idx.get(last).remove(len); //修改最后节点的位置索引
	    	idx.get(last).add(rm);
	    	
	    	nums.remove(len); //删除最后节点
	    	return true;
	    }
	    
	    /** Get a random element from the collection. */
	    public int getRandom() {
	    	int r = (int) (Math.random()*len);
	    	return nums.get(r);
	    }
	}
	
}
