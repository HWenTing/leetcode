package T_201_300;

public class T287 {

//	给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
//	假设只有一个重复的整数，找出这个重复的数。
	
//	不能更改原数组（假设数组是只读的）。
//	只能使用额外的 O(1) 的空间。
//	时间复杂度小于 O(n2) 。
//	数组中只有一个重复的数字，但它可能不止重复出现一次。
	
	
//	没想出来好法子。。 看了题解双指针
	
	
//	双指针，把数组里的值当成下一个元素的下标
//	击败99.8%
//	按照循环链表找第一个节点的方法做就可以
    public int findDuplicate(int[] nums) {
    	//从0位算起
    	int slow = nums[0];//指在第一位
    	int fast = nums[nums[0]];//指在第2位
    	while(slow!=fast){
        	slow = nums[slow];//每次走一步
        	fast = nums[nums[fast]];//每次走两步
    	}
    
    	slow =0;//复位
    	int before1=0;//记录slow的前边一个元素
    	int before2=0;//记录fast前边一个元素
    	while(slow!=fast || before1!=before2 ){//当fast==slow并且它们的父节点的值相同时才停止
    		before1 = slow;
    		before2 = fast;
    		slow =  nums[slow];
    		fast =  nums[fast];
    	}
    	return before1;	
    }
    
	
	
	
	
//    O(n)算法，把当前数字对应下标的数字取负，如果已经是负数说明出现过了，直接返回当前数字的绝对值。
//	这个虽然不符合要求，改变了数组，但思想非常棒，把数组模拟成链表
//    public int findDuplicate(int[] nums) {
//        int n = nums.length;
//        for (int i = 0; i < n; ++i) {
//            if (nums[Math.abs(nums[i])] < 0)
//                return Math.abs(nums[i]);
//            else
//                nums[Math.abs(nums[i])] = -nums[Math.abs(nums[i])];
//        }
//        return 0;
//    }
    
    
    
}
