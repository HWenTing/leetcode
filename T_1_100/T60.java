package T_1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T60 {

    public static String getPermutation(int n, int k) {
        
    	int[] nums = new int[n];
    	for(int i=0;i<n;i++){
    		nums[i]=i+1;
    	}

    	List<Integer> temp = new ArrayList<Integer>();
    	
    	for(int j =0;j<k-1;j++){	
    		nextPermutation(nums);
    	}
    	String ans="";
    	for(int i =0;i<n;i++){
    		ans+=nums[i];
    	}
    	
    	return ans;
    	
    	
    	
    }
    
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
    
    
    
    public static int fa(int n){
    	int ans=1;
    	for(int i=2;i<=n;i++){
    		ans*=i;
    	}
    	return ans;
    }
    
    public static void main(String[] args){
    	
    	System.out.println(getPermutation(3,3));
    }
    
    
}
