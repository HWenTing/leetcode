package Tc_contest;

public class LCP_19 {

//	小扣出去秋游，途中收集了一些红叶和黄叶，他利用这些叶子初步整理了一份秋叶收藏集 leaves， 
//	字符串 leaves 仅包含小写字符 r 和 y， 其中字符 r 表示一片红叶，字符 y 表示一片黄叶。
//	出于美观整齐的考虑，小扣想要将收藏集中树叶的排列调整成「红、黄、红」三部分。
//	每部分树叶数量可以不相等，但均需大于等于 1。每次调整操作，小扣可以将一片红叶替换成黄叶或者将一片黄叶替换成红叶。
//	请问小扣最少需要多少次调整操作才能将秋叶收藏集调整完毕。

//	动态规划 
//	dp[i][0] 表示[0,i]满足「红」所需要变化的最小数
//	dp[i][1] 表示[0,i]满足「红、黄」所需要变化的最小数
//	dp[i][2] 表示[0,i]满足「红、黄、红」所需要变化的最小数
    public int minimumOperations(String leaves) {
    	
    	int[][] dp = new int[leaves.length()][3];
    	
    	dp[0][0] = (leaves.charAt(0)=='r'?0:1);
    	dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
    	
    	for(int i=1;i<leaves.length();i++){
    		
    		dp[i][0] = dp[i-1][0]+(leaves.charAt(i)=='r'?0:1);
    		dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1])+(leaves.charAt(i)=='y'?0:1);
    		if(i>1)
    			dp[i][2] = Math.min(dp[i-1][1], dp[i-1][2])+(leaves.charAt(i)=='r'?0:1);
    	}
    	
    	return dp[leaves.length()-1][2];
    }
}
