package SwordToOffer;

import java.util.LinkedList;

public class T59_1 {

//	给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
	
//	同T239
//	单调递减队列
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if(nums.length==0) return new int[0];
    	LinkedList<Integer> queue = new LinkedList<>();
    	queue.add(0);
    	int i=1;
    	for(;i<k;i++){
    		while(!queue.isEmpty() && nums[i]>nums[queue.getLast()])
    			queue.pollLast();
    		queue.add(i);
    	}
    	
    	int[] ret = new int[nums.length+1-k];
    	int j=0;
    	ret[j++] = nums[queue.peek()];
    	
    	for(;i<nums.length;i++){
    		if(queue.peek()+k==i)
    			queue.pollFirst();
    		while(!queue.isEmpty() && nums[i]>nums[queue.getLast()])
    			queue.pollLast();
    		queue.add(i);
    		ret[j++] = nums[queue.peek()];
    	}
    	return ret;
    	
    }
    
}
