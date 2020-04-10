package T_101_200;

public class T154 {
//
//	假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//	( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//	请找出其中最小的元素。
//	注意数组中可能存在重复的元素。

// 	在T153的基础上增加了一点  当遇到重复元素的时候的处理方式	
//	和 T33  T81也很像
//	剑指offerT11
    public int findMin(int[] nums) {
        int right = nums.length-1;
        int left = 0;
        int minright = nums[right];
        while(left<right){
        	int mid = left+(right-left)/2;
        	if(mid!=left && nums[mid]==nums[left]){//如果nums[mid]和nums[left]相等 就让left走一步
        		left++;
        		continue;
        	}
        	if(nums[mid]<=minright){//说明转折点在mid左侧
        		minright = nums[mid];
        		right=mid;
        	}else{//说明在mid右侧
        		left=mid+1;
        	}
        	
        }
        return nums[left];
    }
    
}
