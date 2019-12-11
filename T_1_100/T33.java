package T_1_100;

public class T33 {

//	假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//	( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//	搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//	你可以假设数组中不存在重复的元素。
//	你的算法时间复杂度必须是 O(log n) 级别。

//	二分法，每次将搜寻的区域分成两部分，一部分有序，一部分可能存在旋转的节点，然后log
//	将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。此时有序部分用二分法查找。
//	无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
  
	public int search(int[] nums, int target) {
    	if(nums.length==0) return -1;
    	int left=0;
    	int right = nums.length-1;
    	int mid;
        while(left<right){
        	mid = left+(right-left)/2;
        	if(target==nums[mid])
        		return mid;
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
        return nums[left]==target?left:-1;
        
    }
    
}
