package T_1_100;

public class T33 {

	public static int find(int[] nums,int start,int end,int target){
   
		if(start==end){
			return nums[start]==target?start:-1;
		}
        int mid=(start+end)/2;

        while(start<end ){
        	if(nums[mid]==target){
        		return mid;
        	}else if(nums[mid]<target){
        		start=mid+1;
        		mid=(start+end)/2;
        	}else{
        		end=mid;
        		mid=(start+end)/2;
        	}
        }

        return nums[mid]==target?mid:-1;
       
        
	}
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int right = len-1;
        int left = 0;
        int mid=right/2;
        
        if (len<1){
        	return -1;
        }
        
        while(left<right-1){
        	if(nums[mid]<nums[right]){
        		right=mid;
        		mid=(right+left)/2;
        	}else{
        		left=mid;
        		mid=(right+left)/2;
        	}
        }
        
//        return mid;

        
        int l = find(nums,0,mid,target);
        int r = find(nums,mid+1,len-1,target);
        return l>=r?l:r;

    }
    
    public static void main(String[] args){
    	int[] nums={1,3,5};

//    	System.out.println(find(nums,1,2,5));
    	
    	System.out.println(search(nums,5));
    }
}
