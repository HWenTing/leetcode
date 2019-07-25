package T_401_500;

import java.util.Arrays;

public class T462 {

//	第一感觉是找中位数，尝试一下
//	没问题 一次ac
    public int minMoves2(int[] nums) {
    	int len = nums.length;
    	if(len<2)
    		return 0;
    	Arrays.sort(nums);
    	
    	int pos = len/2;
    	int standard = nums[pos];
    	int ans=0;
    	for(int i:nums)
    		ans+=Math.abs(i-standard);
    	return ans;
    }
    
    public static void main(String[] args){
    	T462 t =new T462();
    	int nums[]= new int[]{1 ,1,100}; 
    	System.out.println(t.minMoves2(nums));
    }
}
