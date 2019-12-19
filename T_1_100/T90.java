package T_1_100;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T90 {
//	给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//	说明：解集不能包含重复的子集。
	
//	一遍ac 先排序，在用T78的方法 回溯 在回溯时多加一个条件即可
	List<List<Integer>> ans;
	int len;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans = new LinkedList<>();
	    len = nums.length;
	    ans.add(new LinkedList<>());
	    for(int i=0;i<len;i++){
	    	if(i==0 || nums[i]!=nums[i-1])//和T78唯一的区别
	    		flashback(nums,i,new LinkedList<>());
	    }
	    return ans;
    }
	private void flashback(int[] nums, int curpos,LinkedList<Integer> temp) {
		temp.add(nums[curpos]);
		ans.add(new LinkedList<>(temp));
		curpos++;
		for(int i=curpos;i<len;i++){
			if(i==curpos || nums[i]!=nums[i-1])//和T78唯一的区别 
				flashback(nums,i,temp);
		}
		temp.remove(temp.size()-1);
	} 
}
