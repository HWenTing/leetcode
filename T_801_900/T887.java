package T_801_900;

public class T887 {
//	https://github.com/Shellbye/Shellbye.github.io/issues/42 讲的很好
	
//	下边一步步时间优化
	
//	从第x层扔了一个，根据鸡蛋碎不碎分成两部分，上边dp(K,N−X)，下边dp(K−1,X−1)
//	1.暴力递归
//	超时
//    public int superEggDrop(int K, int N) {
//    	if(K==1 || N==0 || N==1){
//    		return N;
//    	}
//    	int ans=N;
//    	for(int i=1;i<N;i++){
//    		int temp = 1+Math.max(superEggDrop(K-1,i-1), superEggDrop(K,N-i));
//    		ans = Math.min(ans, temp);
//    	}
//    	return ans;
//    }
    
    
//	2.记忆化，把中间结果保存下来，减少重复计算
//	还是超时
//	int[][] map ;
//	boolean[][] visit ;
//    public int superEggDrop(int K, int N) {
//    	map = new int[K+1][N+1];
//    	visit = new boolean[K+1][N+1];
//    	return dfs(K,N);
//    }
//    
//    private int dfs(int K, int N){
//    	if(K==1 || N==0 || N==1){
//    		return N;
//    	}
//    	if(visit[K][N]) return map[K][N];
//    	
//    	int ans=N;
//    	for(int i=1;i<N;i++){
//    		int a1 ,a2;
//    		if(!visit[K-1][i-1]){
//    			map[K-1][i-1] = dfs(K-1,i-1);
//    			visit[K-1][i-1]=true;
//    		}
//    		a1 = map[K-1][i-1];
//    		
//    		if(!visit[K][N-i]){
//    			map[K][N-i] = dfs(K,N-i);
//    			visit[K][N-i]=true;
//    		}
//    		a2 = map[K][N-i];
//    		
//    		
//    		int temp = 1+Math.max(a1, a2);
//    		ans = Math.min(ans, temp);
//    	}
//    	map[K][N]=ans;
//    	visit[K][N]=true;
//    	return ans;
//    }
    
	
//	矩阵链乘法 ，关键还是分解方程
//	还是超时。。。O(KN^2)
//    public int superEggDrop(int K, int N) {
//        int[][] middleResults = new int[K + 1][N + 1];
//        for (int i = 1; i <= N; i++) {
//            middleResults[1][i] = i; // only one egg
//            middleResults[0][i] = 0; // no egg
//        }
//        for (int i = 1; i <= K; i++) {
//            middleResults[i][0] = 0; // zero floor
//        }
//
//        for (int k = 2; k <= K; k++) { // start from two egg
//            for (int n = 1; n <= N; n++) {
//                int tMinDrop = N * N;
//                for (int x = 1; x <= n; x++) {
//                    tMinDrop = Math.min(tMinDrop, 1 + Math.max(middleResults[k - 1][x - 1], middleResults[k][n - x]));
//                }
//                middleResults[k][n] = tMinDrop;
//            }
//        }
//        return middleResults[K][N];
//    }
    
	
//   题解给的答案 复杂度Okn  但是我没看懂。。。。。。。
//    public int superEggDrop(int K, int N) {
//        // Right now, dp[i] represents dp(1, i)
//        int[] dp = new int[N+1];
//        for (int i = 0; i <= N; ++i)
//            dp[i] = i;
//
//        for (int k = 2; k <= K; ++k) {
//            // Now, we will develop dp2[i] = dp(k, i)
//            int[] dp2 = new int[N+1];
//            int x = 1;
//            for (int n = 1; n <= N; ++n) {
//                // Let's find dp2[n] = dp(k, n)
//                // Increase our optimal x while we can make our answer better.
//                // Notice max(dp[x-1], dp2[n-x]) > max(dp[x], dp2[n-x-1])
//                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
//                while (x < n && Math.max(dp[x-1], dp2[n-x]) > Math.max(dp[x], dp2[n-x-1]))
//                    x++;
//
//                // The final answer happens at this x.
//                dp2[n] = 1 + Math.max(dp[x-1], dp2[n-x]);
//            }
//
//            dp = dp2;
//        }
//
//        return dp[N];
//    }
	
	
	
    public int superEggDrop(int K, int N) {
//    	dp[k][m]表示k个鸡蛋在m步内可以完全测出的最多的层数
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            dp[0][m] = 0; // zero egg
            for (int k = 1; k <= K; k++) {
//            	保证如果鸡蛋碎了，比X低的层数一定要能够用F(t-1,k-1)确定出来，
//            	如果鸡蛋没碎，比X高的层数一定要能够用F(t-1,k)确定出来，
//            	再加上本层，就是能够确定的最大层数
            	
//            	或者这样理解  H = dp[k - 1][m - 1]表示K-1个鸡蛋m-1步可以测出来的高度，然后在H+1的位置扔一个鸡蛋
//            	如果碎了，那么剩下k-1个鸡蛋和m-1步，刚好为dp[k - 1][m - 1]
//            	如果没碎，那么还剩k个鸡蛋和m-1步，能测出dp[k][m - 1]高度。
//            	因此 总共可以测出的高度为 totalheight = dp[k][m - 1]  + 1 + dp[k - 1][m - 1]
//            	第一个鸡蛋在H+1的位置扔，若碎了，那么确定F在H下方，那么k-1个鸡蛋即可搞定
//            	如果没碎，那么确定F在H+1的上方（H+2到totalheight之间），还有k个鸡蛋，依然可以搞定
            	
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
                if (dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }
    

}
