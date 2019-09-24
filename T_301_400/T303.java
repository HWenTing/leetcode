package T_301_400;

import java.util.HashMap;

public class T303 {

//	给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
//	多次调用该方法
//	打卡，先都算出来...超内存了。。
	
//	private int[] nums;
//	private int[][] map;
//    public T303(int[] nums) {
//        this.nums = nums;
//        map = new int[nums.length][nums.length];
//        
//        for (int i = 0; i < nums.length; i++) {
//        	map[i][i]=nums[i];
//			for (int j = i+1; j < nums.length; j++) {
//				map[i][j]=map[i][j-1]+nums[j];
//			}
//		}
//    }
//    
//    public int sumRange(int i, int j) {
//        return map[i][j];
//    }
    
	
//	啊 。。。这个题需要记一下，区间和问题，可以找出前缀和然后做差
	private int[] sum;
	public T303(int[] nums) {
	    sum = new int[nums.length + 1];
	    for (int i = 0; i < nums.length; i++) {
	        sum[i + 1] = sum[i] + nums[i];
	    }
	}

	public int sumRange(int i, int j) {
	    return sum[j + 1] - sum[i];
	}
}
