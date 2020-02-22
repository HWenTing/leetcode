package T_401_500;

import java.util.Stack;

public class T456 {

//	给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。
//	设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。

	
	
//	想法是 先求出每个位置左侧的最小值，然后对每个位置遍历右侧所有位置，如果找到min[i-1]<nums[j]<nums[i]则return true
//	复杂度O(n^2)
//    public boolean find132pattern(int[] nums) {
//    	if(nums.length<3) return false;
//
//    	int[] min = new int[nums.length];
//    	min[0] = nums[0];
//    	for(int i=1;i<nums.length;i++){
//    		min[i] = Math.min(min[i-1], nums[i]);
//    	}
//    	
//    	for(int i=1;i<nums.length-1;i++){
//    		if(min[i-1]<nums[i]){
//    			for(int j=i+1;j<nums.length;j++){
//    				if(nums[j]>min[i-1] && nums[i]>nums[j])
//    					return true;
//    			}
//    		}
//    	}
//    	return false;
//    	
//    }
    
//	可以用栈  O(n)
//	min数组维护位置i之前的最小值   代表132模式中的1
//	栈中存放  132模式中的2
	public boolean find132pattern(int[] nums) {
		if(nums.length<3) return false;
    	int[] min = new int[nums.length];
    	min[0] = nums[0];
    	for(int i=1;i<nums.length;i++){
    		min[i] = Math.min(min[i-1], nums[i]);
    	}
    	
    	Stack<Integer> st = new Stack<>();
    	
    	for(int i=nums.length-1;i>=0;i--){
    		 if(nums[i]>min[i]){//1<3条件满足
    			 
    			 while(!st.isEmpty() && st.peek()<=min[i])//确保1<2条件满足
    				 st.pop();
    			 if(!st.isEmpty() && st.peek()<nums[i])//如果3>2条件满足
    				 return true;
    			 st.add(nums[i]);
    		 }
    	}
    	return false;
	
	}
}
