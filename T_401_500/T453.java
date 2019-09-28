package T_401_500;

public class T453 {

//	给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动可以使 n - 1 个元素增加 1
	
//	 n-1个少数民族加分相当于1个民族扣分。对（每个元素与最小值的差）求和即可
//	这个看了题解才有的思路
	
    public int minMoves(int[] nums) {
    	int min=Integer.MAX_VALUE;
        for(int i:nums){
        	min = Math.min(min,i);
        }
        
        int ans=0;
        for(int i:nums){
        	ans+=(i-min);
        }
        return ans;
    }
    
}
