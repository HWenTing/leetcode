package T_1_100;

public class T81 {

//	假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//	( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
//	编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

//	在33题的基础上增加了 重复元素这个条件 
//	增加nums[left]==nums[mid]判断即可，
	public boolean search(int[] nums, int target) {
    	if(nums.length==0) return false;
    	int left=0;
    	int right = nums.length-1;
    	int mid;
        while(left<right){
        	mid = left+(right-left)/2;
        	if(target==nums[mid])
        		return true;
        	if(nums[left]==nums[mid]){
        		left++;
        		continue;
        	}
        	else if(nums[mid]<nums[left]){//mid右侧是有序的
        		if(nums[mid]>target || target>nums[right]){//target只可能存在与左半部分
        			right = mid;
        		}else{
        			left = mid+1;
        		}
        	}else{//左侧是有序的
        		if(target<=nums[mid] && target>=nums[left]){//target只可能存在与左半部分
        			right = mid;
        		}else{
        			left = mid+1;
        		}
        	}
        }
        return nums[left]==target;
        
    }
}
