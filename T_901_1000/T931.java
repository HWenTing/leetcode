package T_901_1000;

public class T931 {
	
//	给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
//	下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。

//	dp,感觉和之前创新实训时的那个dp很像
    public int minFallingPathSum(int[][] A) {
    	if(A.length==0 || A[0].length==0) return 0;
    	
        int[][] dp = new int[A.length][A[0].length];
        for(int i=0;i<A[0].length;i++)
        	dp[0][i]=A[0][i];
        for(int i=1;i<A.length;i++){
        	for(int j=0;j<A[0].length;j++){
        		int n1=Integer.MAX_VALUE;//左上方
        		if(j!=0) n1 = dp[i-1][j-1];
        		
        		int n2 = Math.min(n1, dp[i-1][j]);//正上方
        		
        		int n3=Integer.MAX_VALUE;//右上方
        		if(j!=A[0].length-1) n3 = dp[i-1][j+1];
        		
        		dp[i][j] = Math.min(n3, n2)+A[i][j];
        	}
        }
        int ans = Integer.MAX_VALUE;
        for(int i:dp[A.length-1])//最后一行最小值
        	ans = Math.min(i, ans);
        return ans;
    }
    
}
