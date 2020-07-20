package T_701_800;

public class T718 {

	
//	给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
	
//	第一想法dp  dp[i][j] = dp[i-1][j-1]+1;  dp[i][j] 表示以A[i] B[j] 结尾的最长的公共子数组长度 
//	时间复杂度： O(N×M)
//    public int findLength(int[] A, int[] B) {	
//    	int ans = 0;
//    	int[][]dp = new int[A.length][B.length];
//    	int min = Math.min(A.length, B.length);
//    	
//    	for(int i=0;i<A.length;i++){
//    		for(int j=0;j<B.length;j++){
//    			
//    			if(A[i]==B[j]){
//    				if(i-1<0 || j-1<0) 
//    					dp[i][j]=1;
//    				else
//    					dp[i][j] = dp[i-1][j-1]+1;
//    				ans = Math.max(dp[i][j], ans);
//    			}else
//    				dp[i][j] = 0;
//    		}
//    		if(ans==min) return min;//剪枝
//    	}
//    	
//    	return ans;
//    }
    
	
	//法二：滑动窗口
//	枚举 A 和 B 所有的对齐方式，对于每一种对齐方式，我们计算它们相对位置相同的重复子数组即可。
//	时间复杂度 O((N+M)×min(N,M))
//	A = [3, 6, 1, 2, 4]
//	B = [7, 1, 2, 9]
	
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length;
        int ret = 0;
        for (int i = 0; i < n; i++) {//A向左滑动
            int len = Math.min(m, n - i);
            int maxlen = maxLength(A, B, i, 0, len);
            ret = Math.max(ret, maxlen);
        }
        for (int i = 0; i < m; i++) {//B向左滑动
            int len = Math.min(n, m - i);
            int maxlen = maxLength(A, B, 0, i, len);
            ret = Math.max(ret, maxlen);
        }
        return ret;
    }

    public int maxLength(int[] A, int[] B, int addA, int addB, int len) {
        int ret = 0, k = 0;
        for (int i = 0; i < len; i++) {
            if (A[addA + i] == B[addB + i]) {
                k++;
            } else {
                k = 0;
            }
            ret = Math.max(ret, k);
        }
        return ret;
    }

	
	
	
	
	
}
