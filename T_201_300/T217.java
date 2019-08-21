package T_201_300;

import java.util.HashSet;

public class T217 {

//	判断是否有重复元素
//	用集合做，下边两种方法速度差不多
	 
//	判断是否已经存在
//    public boolean containsDuplicate(int[] nums) {
//        HashSet<Integer> hashset = new HashSet<>();
//        for(int num:nums){
//        	if(hashset.contains(num))
//        		return true;
//        	else
//        		hashset.add(num);
//        }
//        return false;
//    }
    
//	判断长度
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashset = new HashSet<>();
        for(int num:nums){
        	hashset.add(num);
        }
        return hashset.size()!=nums.length;
    }
    
    
}
