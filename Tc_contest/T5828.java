package Tc_contest;

public class T5828 {

//	给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
//	请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
	
//	不适用额外空间好像有特殊的算法
//	先使用额外空间
    public int[] shuffle(int[] nums, int n) {
    	
    	int[] ans=  new int[n*2];
    	int i=0;
    	
    	for(int j=0;j<n;j++){
    		ans[i++] = nums[j];
    		ans[i++] = nums[j+n];
    	}
    	return ans;
    }
    
}
