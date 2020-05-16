package SwordToOffer;

public class T39 {

//	数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
	
//	摩尔投票法
    public int majorityElement(int[] nums) {
    	int cnt = 0;
    	int max = -1;
    	
    	for(int i=0;i<nums.length;i++){
    		if(cnt==0){
    			cnt=1;
    			max = nums[i];
    			continue;
    		}
    		
    		if(nums[i]==max)
    			cnt++;
    		else
    			cnt--;
    	}
    	return max;
    }
    
}
