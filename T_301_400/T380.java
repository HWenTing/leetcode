package T_301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T380 {

//	速度击败83%，内存击败76%
//	一个hashmap<val，数组的下标>
//	一个list，紧密存放val
//	insert操作就把val放在list最后，并且在map中加入<val,list中的位置> 复杂度1
//	remove操作，首先通过map获得val在list中的位置，然后删除map中的元组，然后将list最后的元素放到删除后空缺的位置，
//	再把最后一个元素删掉，同时修改map对应的值即可。 复杂度1
//	getRandom操作， 再list.size的范围内随机选一个位置即可
	
	
    public T380() {
        
    }
	HashMap<Integer,Integer> map =new HashMap<>();//<值，数组的下标>
	List<Integer> nums =new ArrayList<>();
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if(map.containsKey(val))
    		return false;
    	map.put(val, nums.size());//设置map
    	nums.add(val);//设置nums
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(!map.containsKey(val))
    		return false;
    	int pos = map.get(val);//获取删除位置
    	map.remove(val);//更新map
    	
    	if(pos!=nums.size()-1){
        	int newval=nums.get(nums.size()-1);//最后位置的值
        	nums.set(pos, newval);//删除位置设为该值
        	map.put(newval, pos);//更新map
        	nums.remove(nums.size()-1);//更新nums，删除最后节点
    	}else{
    		nums.remove(nums.size()-1);//更新nums，删除最后节点
    	}
    	
    	return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	return nums.get((int)(Math.random()*nums.size()));
    }
    
    
    public static void main(String[] args){
    	T380 randomSet =new T380();
    	
    	randomSet.insert(0);

    	randomSet.remove(0);

    	randomSet.insert(-1);

    	randomSet.remove(0);

    	System.out.println(randomSet.getRandom());;
    }
    
}
