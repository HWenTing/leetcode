package T_401_500;

import java.util.LinkedList;
import java.util.List;

public class T448 {
	
//	给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//	找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//
//	不使用额外空间且时间复杂度为O(n)

//	不使用额外数组的话，可能就要更改本数组了,把nums[pos]看作下一个位置，访问到标记为-1，表示数组中存在指到该位置的索引，即存在pos值
//	击败73%
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//    	List<Integer> ans = new LinkedList<>();
//    	for(int i=0;i<nums.length;i++){
//    		int pos=nums[i]-1;
//    		while(pos>=0){//根据下标找下一个
//    			int next = nums[pos]-1;
//    			nums[pos]=-1;
//    			pos = next;
//    		}
//    	}
//    	
//    	for(int i=0;i<nums.length;i++){//没被标记到的位置表明没有该数
//    		if(nums[i]>0){
//    			ans.add(i+1);
//    		}
//    	}
//    	return ans;
//    }
    
	
//	一个思路相似但是看起来更牛逼的方法
//	将数组元素对应为索引的位置加n
//	遍历加n后的数组，若数组元素值小于等于n，则说明数组下标值不存在，即消失的数字
//	击败72%。。。差不多
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> ans = new LinkedList<>();
    	int len = nums.length;
    	for(int i=0;i<len;i++){
    		nums[(nums[i]-1)%len]+=len;
    	}
    	
    	for(int i=0;i<nums.length;i++){//没被标记到的位置表明没有该数
    		if(nums[i]<=len){
    			ans.add(i+1);
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args){
    	T448 t = new T448();
    	int[] nums = new int[]{4,3,2,7,8,2,3,1};
    	t.findDisappearedNumbers(nums);
    	
    }
}
