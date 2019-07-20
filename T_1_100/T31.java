package T_1_100;

import java.util.Arrays;

public class T31 {

    public static void nextPermutation(int[] nums) {
    	int len = nums.length;
    	boolean ischange=false;
    	for(int i =len-1;i>0;i--){
    		if(nums[i]>nums[i-1]){
    			Arrays.sort(nums, i, len);
    			for(int j=i;j<len;j++){
    				if(nums[j]>nums[i-1]){
    	    			int temp = nums[i-1];
    	    			nums[i-1] = nums[j];
    	    			nums[j]  = temp;
    	    			break;
    				}
    			}

    			
    			Arrays.sort(nums, i, len);
    			ischange = true;
    			break;
    		}
    	}
    	if(!ischange)
    		Arrays.sort(nums);
        
    }
    
    public static void main(String[] args){
    	int[] aa = {1,3,2};
    	nextPermutation(aa);
    	for(int a :aa){
    		System.out.print(a+" ");
    	}
    }
    
    
}
