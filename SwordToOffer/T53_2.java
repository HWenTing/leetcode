package SwordToOffer;

public class T53_2 {

	
//	一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
//	在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

//	排序想二分
	
    public int missingNumber(int[] nums) {
    	int left = 0;
    	int right = nums.length-1;
    	int mid = right - (right-left+1)/2;
    	
    	while(right>left){
    		if(nums[mid]>mid){//左边缺
    			right = mid;
    			mid = right - (right-left+1)/2;
    		}else{//右边缺
    			left = mid+1;
    			mid = right - (right-left+1)/2;
    		}
    	}
    	return nums[left] == left?left+1:left;//注意一下细节
    }
    
}
