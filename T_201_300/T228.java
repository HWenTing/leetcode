package T_201_300;

import java.util.LinkedList;
import java.util.List;

public class T228 {

//	数组处理，比较简单
    public List<String> summaryRanges(int[] nums) {
        
    	LinkedList<String> ans = new LinkedList<>();
    	if(nums.length<1) return ans;
    	int start=nums[0];
    	
    	for(int i=1;i<nums.length;i++){
    		if(nums[i]-nums[i-1]==1)
    			continue;
    		else{
    			if(start!=nums[i-1])
    				ans.add(start+"->"+nums[i-1]);
    			else 
    				ans.add(start+"");
    			start = nums[i];
    		}
    	}
    	if(start!=nums[nums.length-1])
    		ans.add(start+"->"+nums[nums.length-1]);
		else 
			ans.add(start+"");
    	
    	return ans;
    }
    
}
