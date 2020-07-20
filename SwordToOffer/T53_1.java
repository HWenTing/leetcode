package SwordToOffer;

public class T53_1 {

//	统计一个数字在排序数组中出现的次数。
	
//	二分
    public int search(int[] nums, int target) {
    	if(nums.length==0) return 0;
    	int left = 0;
    	int right = nums.length-1;
    	int mid = right - (right-left+1)/2;
    	while(right>left){
    		if(nums[mid]<target){
    			left = mid+1;
    			mid = right - (right-left+1)/2;
    		}else if(nums[mid]>target){
    			right = mid;
    			mid = right - (right-left+1)/2;
    		}else{
    			break;
    		}
    	}
    	
    	if(nums[mid]!=target) return 0;
    	else{//找到target位置，然后向前后扩展
    		int ans=1;
    		int i = mid+1;
    		while(i<nums.length &&nums[i]==target ){
    			ans++;
    			i++;
    		}
    		i = mid-1;
    		while(i>=0 &&nums[i]==target ){
    			ans++;
    			i--;
    		}
    		return ans;
    	}
    }
    
}
