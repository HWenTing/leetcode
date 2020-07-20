package T_1_100;

import java.util.HashMap;

public class T96 {
//	给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
//	递归或者动态规划
	
//	纯递归的话很容易超时,可以用map存起来
//	HashMap<Integer,Integer> map = new HashMap<>();
//    public int numTrees(int n) {
//    	return subnumTrees(n,n);
//    }
//
//    private int subnumTrees(int n,int N){
//    	if(n<=1)
//    		return 1;
//    	if(map.containsKey(n))
//    		return map.get(n);
//    	
//    	int ans=0;
//        for(int i=1;i<=n;i++){//以每一个节点当作根节点，情况为左子树可能*右子树可能
//        	ans+=map.getOrDefault(i-1, subnumTrees(i-1,N))*map.getOrDefault(n-i, subnumTrees(n-i,N));
//        }
//        map.put(n, ans);
//        return ans;
//    }
    
//	动态规划 快很多
	  public int numTrees(int n) {
		  int[] dp = new int[n+1];
		  dp[0]=dp[1]=1;
		  
		  for(int i=2;i<=n;i++){//i表示n的值，即树所包含的节点数
			  for(int j=1;j<=i;j++){//以j为根节点构造
				  dp[i]+=(dp[j-1]*dp[i-j]);
			  }
		  }
		  return dp[n];
	  }
}
