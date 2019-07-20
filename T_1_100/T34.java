package T_1_100;

public class T34 {

	public static int findleft(int[] nums,int start,int end,int target){
		if(end - start <2){
			for(int i =start;i<=end;i++){
				if(nums[i] == target){
					return i;
				}
			}
			return -1;
		}
		int mid = (start+end)/2;
		if(nums[mid] == target){
			if(mid==0 || nums[mid-1]!=target){
				return mid;
			}else{
				return findleft(nums,start,mid,target);
			}
				
		}else if(nums[mid] > target){
			return findleft(nums,start,mid,target);
		}else{
			return findleft(nums,mid,end,target);
		}
	}
	
	public static int findright(int[] nums,int start,int end,int target){
		if(end - start <2){
			for(int i =end;i>=start;i--){
				if(nums[i] == target){
					return i;
				}
			}
			return -1;
		}
		
		int mid = (start+end)/2;
		if(nums[mid] == target){
			if(mid==nums.length-1 || nums[mid+1]!=target){
				return mid;
			}else{
				return findright(nums,mid,end,target);
			}
				
		}else if(nums[mid] > target){
			return findright(nums,start,mid,target);
		}else{
			return findright(nums,mid,end,target);
		}
	}
	
	
    public static int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        int len = nums.length;
        
        if(len==0){
        	ans[0]=ans[1]=-1;
        	return ans;
        }
        
        ans[0] = findleft(nums,0,len-1,target);
        ans[1] = findright(nums,0,len-1,target);
        return ans;
    }
    
    public static void main(String[] args){
    	int[]  aa = {1};
    	
//    	System.out.println(findleft(aa,0,6,8));
//    	System.out.println(findright(aa,0,6,10));
    	int[] ans = searchRange(aa,1);
    	System.out.println(ans[0]+" "+ans[1]);
    	
    }
    
}
