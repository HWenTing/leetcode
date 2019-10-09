package T_701_800;

public class T704 {

//	给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
    
//	二分查找 注意细节
	public int search(int[] nums, int target) {
		int left=0;
		int right=nums.length-1;
        int mid;
        while(left<=right){
        	mid=left+(right-left)/2;
        	if(nums[mid]==target)
        		return mid;
        	else if(nums[mid]<target){
        		left=mid+1;
        	}else{
        		right=mid-1;
        	}
        }
        return -1;
    }
    
}
