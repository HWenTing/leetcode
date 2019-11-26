package T_801_900;

public class T877 {

//	亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
//	游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
//	亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
//	假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。

//	和T486完全相同
//	偶数个数一定先手赢，因为先手可以判断奇数列和 和 偶数列和，如果偶数和大，那么每次只选偶数位的即可
//	因为这个是偶数。。。所以一定赢。。
    public boolean stoneGame(int[] piles) {
    	int[][] dp = new int[piles.length][piles.length];
    	
    	for(int i=piles.length-1;i>=0;i--){
    		dp[i][i]=piles[i];
    		for(int j=i+1;j<piles.length;j++){
    			dp[i][j] = Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
    		}
    	}
    	return dp[0][piles.length-1]>=0;
    }
    
    
}
