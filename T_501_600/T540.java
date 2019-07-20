package T_501_600;


public class T540 {
	//无序数组可用此方法，n时间复杂度
    public int singleNonDuplicate2(int[] nums) {
    	
    	int ans = nums[0];
    	int len = nums.length;
        for(int i=1;i<len;i++){
        	ans = ans^nums[i];
        }
        return ans;
    }
    
//    有序数组 logn复杂度
    public int singleNonDuplicate(int[] nums) {
    	int l=0;
    	int h=nums.length-1;
    	if(h<1){
    		return nums[0];
    	}
    	
    	while(l<h){
    		int mid = l+(h-l)/2;
    		if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
    			return nums[mid];
    		}else if(nums[mid] == nums[mid-1] ){
    			if(mid%2==0){
    				h = mid;
    			}else{
    				l = mid+1;
    			}
    			
    		}else{
    			
    			if(mid%2==0){
    				l = mid;
    			}else{
    				h = mid-1;
    			}
    			
    		}
    	}
    	return nums[l];
    	
    }
    
    
    public static void main(String []args){
    	T540 t = new T540();
    	int[] a = {3,3,7,7,10,11,11};
    	System.out.println(t.singleNonDuplicate(a));
    }
}
