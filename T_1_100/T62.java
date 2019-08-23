package T_1_100;

import java.util.Arrays;

public class T62 {

////	非dp,直接用公式组合数 !!!!!!!注意溢出问题
//    public int uniquePaths(int m, int n) {
//        int total = m+n-2;
//        int min = Math.min(m-1,n-1);
//        if(min<0)
//        	return 0;
//        if(min==0)
//        	return 1;
//        long fenzi = 1;//这里的取值可能会溢出！！！！改为long
//        for(int i=0;i<min;i++){
//        	fenzi*=total--;
//        }
//        long fenmu = 1;
//        int count = min;
//        for(int i =0;i<min;i++){
//        	fenmu*=count--;
//        }
//        return (int)(fenzi/fenmu);
//    }
    
	
//	使用动态规划 a[i][j] = a[i-1][j]+a[i][j-1] 进一步可以转化成dp[j] = dp[j]+dp[j-1] 其中的dp[j-1]代表a[i][j-1]，dp[j]代表 a[i-1][j]
	public int uniquePaths(int m, int n) {//m col  n row
		int[] dp = new int[m];
		Arrays.fill(dp, 1);
		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){//dp[j-1]代表该层左边，dp[j]代表该列的上一层转移过来
				dp[j] = dp[j]+dp[j-1];
			}
		}
		
		return dp[m-1];
	}
    
	
	
	public static void main(String[] args) {
		T62 t = new T62();
		System.out.println(t.uniquePaths(10,10));
	
	}

}
