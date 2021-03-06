package T_101_200;

public class T153 {
//	假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//	( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//	请找出其中最小的元素。
//	你可以假设数组中不存在重复元素。

//	二分法 找到旋转的节点	
    public int findMin(int[] nums) {
        int right = nums.length-1;
        int left = 0;
        int minright = nums[right];
        while(left<right){
        	int mid = left+(right-left)/2;
        	if(nums[mid]<=minright){
        		minright = nums[mid];
        		right=mid;
        	}else{
        		left=mid+1;
        	}
        	
        }
        return nums[left];
    }
    
}
