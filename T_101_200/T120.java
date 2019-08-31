package T_101_200;

import java.util.Arrays;
import java.util.List;

public class T120 {

	
//	给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
	
//	dp解决，内存应该可以进一步优化，每一层从右往左（因为用到了dp[i-1]）
//	击败63%
//    public int minimumTotal(List<List<Integer>> triangle) {
//        int layers = triangle.size();
//        int[][] dp = new int[layers][layers];
//
//        
//        dp[0][0]=triangle.get(0).get(0);
//        for(int layer=1;layer<layers;layer++){
//            Arrays.fill(dp[layer], Integer.MAX_VALUE);
//        	List<Integer> cur = triangle.get(layer);
//        	dp[layer][0]=dp[layer-1][0]+cur.get(0);//最左边
//        	for(int i=1;i<cur.size()-1;i++){//中间为两种状态的最小值
//        		dp[layer][i] = Math.min(dp[layer-1][i-1],dp[layer-1][i])+cur.get(i);
//        	}
//        	dp[layer][cur.size()-1]=dp[layer-1][cur.size()-2]+cur.get(cur.size()-1);//最右边 注意cur.size()-2
//        }
//        
//        int ans=Integer.MAX_VALUE;
//        for(int i:dp[layers-1]){
//        	ans = Math.min(ans, i);
//        }
//        return ans;
//    }
    
    
//	优化内存 使用On空间
    public int minimumTotal(List<List<Integer>> triangle) {
        int layers = triangle.size();
        int[] dp = new int[layers];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0]=triangle.get(0).get(0);
        for(int layer=1;layer<layers;layer++){//每一层从右往左
        	List<Integer> cur = triangle.get(layer);
        	dp[cur.size()-1]=dp[cur.size()-2]+cur.get(cur.size()-1);//最右边 注意cur.size()-2
        	
        	for(int i=cur.size()-2;i>0;i--){//中间为两种状态的最小值,注意cur.size()-2
        		dp[i] = Math.min(dp[i-1],dp[i])+cur.get(i);
        	}
        	dp[0]=dp[0]+cur.get(0);//最左边
        }
        
        int ans=Integer.MAX_VALUE;
        for(int i:dp){
        	ans = Math.min(ans, i);
        }
        return ans;
    }
    
}
