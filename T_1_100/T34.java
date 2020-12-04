package T_1_100;

public class T34 {

	
//	给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//	如果数组中不存在目标值 target，返回 [-1, -1]。
	
//	log 二分
	class Solution {
	    public int[] searchRange(int[] nums, int target) {
	        int[] ans = new int[2];
	        if(nums.length<1) return new int[]{-1,-1};
	        ans[0] = searchLeft(nums,target,0,nums.length-1);
	        ans[1] = searchRight(nums,target,0,nums.length-1);
	        return ans;
	    }

	    private int searchLeft(int[] nums, int target,int start,int end ){
	        if(end-start<0)
	            return -1;
	        else if(end == start)
	            return nums[end]==target?end:-1;
	        
	        int mid = (end-start)/2+start;
	        if(nums[mid]==target){
	            if(mid==start || nums[mid-1]!=target)
	                return mid;
	            else
	                return searchLeft(nums,target,start,mid-1);
	        }else if(nums[mid]>target)
	            return searchLeft(nums,target,start,mid-1);
	        else
	            return searchLeft(nums,target,mid+1,end);
	    }

	    private int searchRight(int[] nums, int target,int start,int end){
	        if(end-start<0)
	            return -1;
	        else if(end == start)
	            return nums[end]==target?end:-1;

	        int mid = (end-start)/2+start;
	        if(nums[mid]==target){
	            if(mid==end || nums[mid+1]!=target)
	                return mid;
	            else
	                return searchRight(nums,target,mid+1,end);
	        }else if(nums[mid]>target)
	            return searchRight(nums,target,start,mid-1);
	        else
	            return searchRight(nums,target,mid+1,end);
	    }

	}
    
}
