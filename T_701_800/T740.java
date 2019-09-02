package T_701_800;

import java.util.HashMap;

public class T740 {

//	每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
//	开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。

//	转换一下数组，就变成打家劫舍问题
//	击败10% ，数组有点大，可以优化一下 
//    public int deleteAndEarn(int[] nums) {
//    	int len = nums.length;
//        int[] value = new int[10001];
//        
//        for(int i:nums)
//        	value[i]+=i;
//        
//        int[] dp = new int[10001];
//        dp[1]=value[1];
//        for(int i=2;i<10001;i++){
//        	dp[i] = Math.max(dp[i-2]+value[i], dp[i-1]);
//        }
//        return dp[10000];
//    }
    
	
//	记录下出现的最大的数,击败68%
  public int deleteAndEarn(int[] nums) {
    int[] value = new int[10001];
    int max = 0;
    
    for(int i:nums){
    	value[i]+=i;
    	max = Math.max(max, i);
    }
    
    int[] dp = new int[10001];
    dp[1]=value[1];
    for(int i=2;i<=max;i++){
    	dp[i] = Math.max(dp[i-2]+value[i], dp[i-1]);
    }
    return dp[max];
}
	
	
//	好吧更慢了，下边的方法废了
//    public int deleteAndEarn(int[] nums) {
//    	int len = nums.length;
//        HashMap<Integer,Integer> value = new HashMap<>();
//        int max=0;
//        
//        for(int i:nums){
//        	value.put(i, value.getOrDefault(i, 0)+i);
//        	max = Math.max(max, i);
//        }
//        
//        int[] dp = new int[10001];
//        dp[1]=value.getOrDefault(1, 0);
//        for(int i=2;i<=max;i++){
//        	dp[i] = Math.max(dp[i-2]+value.getOrDefault(i, 0), dp[i-1]);
//        }
//        return dp[max];
//    }
}
