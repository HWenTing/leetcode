package T_1_100;

import java.util.*;

public class T47 {

    public  static boolean nextPermutation(int[] nums) {
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
    			return true;
    		}
    	}
    	if(!ischange)
    		return false;
    	return true;
    }
    
    
    public static List<List<Integer>> permuteUnique(int[] nums) {
    	int len = nums.length;
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	List<Integer> temp = new ArrayList<Integer>();
    	for(int i =0;i<len;i++){
    		temp.add(nums[i]);
    	}
    	ans.add(temp);
    	boolean con = true;
    	
    	while(con){
    		
    		con = nextPermutation(nums);
    		
    		temp = new ArrayList<Integer>();
        	for(int i =0;i<len;i++){
        		temp.add(nums[i]);
        	}
        	
        	if(con)
        		ans.add(temp);
    	}
    	return ans;
    }
    

    
    public static void main(String[] args){
    	int[] candidates = {1,1,3};
    	
    	System.out.println(permuteUnique(candidates));
    }
    
}
