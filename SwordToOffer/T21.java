package SwordToOffer;

public class T21 {

//	输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
	
//	双指针
    public int[] exchange(int[] nums) {

    	int left = 0;
    	int right = nums.length-1;
    	
    	while(right>left){
    		while(right>left && nums[left]%2==1)
    			left++;
    		while(right>left && nums[right]%2==0)
    			right--;
    		
    		int temp = nums[left];
    		nums[left] = nums[right];
    		nums[right] = temp;
    		left++;
    		right--;
    	}
    	
    	return nums;
    }
    
}
