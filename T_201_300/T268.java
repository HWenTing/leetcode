package T_201_300;

public class T268 {

//	给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数
	
//	异或
    public int missingNumber(int[] nums) {
    	int len = nums.length;
    	int ans = len;
    	for(int i=0;i<len;i++){
    		ans^=i;
    		ans^=nums[i];
    	}
    	return ans;
    }
}
