package SwordToOffer;

public class T03 {

//	找出数组中重复的数字。
//	在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
//	数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

//	数组标记一下 空间按复杂度O(n) 时间复杂度O(n)
//    public int findRepeatNumber(int[] nums) {
//
//    	boolean[] marked = new boolean[nums.length];
//    	for(int i:nums){
//    		if(marked[i])
//    			return i;
//    		marked[i]=true;
//    	}
//    	return -1;
//    }
    
//    如果要求不能使用额外空间 那就原地排序 然后判断相邻的有没有相同的元素。空间按复杂度O(1) 时间复杂度O(nlogn)
//    不过如果在冒泡的过程中特判一下可能快一点
    
    
//    也可以原地hash 类似链表那样 空间复杂度O(1) 时间复杂度O(n)
    public int findRepeatNumber(int[] nums) {

    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==i) continue;//不需要换位置

    		int cur = nums[nums[i]];//先把初始位置的正确位置上的值拿起来
    		nums[nums[i]] = nums[i];//把初始位置的值放到该放的位置
    		nums[i]=-1;//先把环的初始位置设为-1
    		
    		
    		while(nums[cur]!=-1){//出了while循环说明环到头了
    			if(nums[cur] == cur)//说明重复元素
    				return cur;	
    			
    			int nextpos = nums[cur];//拿出nums[cur]
    			nums[cur] = cur;//把cur放进去
    			cur = nextpos;//替换cur
    		}
    		
    		//
    		nums[cur] = cur;
    		
    	}
    	return -1;
    }
    
    
}
