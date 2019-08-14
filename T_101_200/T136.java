package T_101_200;
import java.util.Arrays;

public class T136 {
	
//	常规方法
//	 public static int singleNumber(int[] nums) {
//	        Arrays.sort(nums);
//	        for(int i =0;i<nums.length-2;i+=2){
//	        	if(nums[i]!=nums[i+1])
//	        		return nums[i];
//	        }
//	        return nums[nums.length-1];
//	 }
	
	
//	因为通过异或操作，出现两次的数字相当与没有出现，只留下了出现一次的数字
    public static  int singleNumber(int[] nums) {
    	int ans=1;
        for(int i:nums)
        	ans = ans^i;
        ans = ans^1;
        return ans;
    }
    
	 
	 public static void main(String [] args){
		 int a [] = {2,1,2};
		 System.out.println(singleNumber(a));
	 }
}
