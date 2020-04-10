package SwordToOffer;

public class T14_1 {

//	给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
//	请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？
//	例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
//
//	同T343  dp[i]表示长度为i的绳子的最大乘积
    public int cuttingRope(int n) {
    	if(n<=3) return n-1;
    	
    	int[] dp = new int[n+1];
    	dp[1] = 1;
    	dp[2] = 1;
    	for(int i=3;i<=n;i++){
    		dp[i] = i-1;
    		for(int j=1;j<i;j++){
    			dp[i] = Math.max(dp[i], Math.max(dp[i-j], i-j)*Math.max(dp[j], j));//断成两份，考虑将每份最大化
    		}
    	}
    	return dp[n];
    }
    
//    也有数学方法
//    能切成3的都切成3，最后只留2、3、4
//    public int cuttingRope(int n) {
//        if (n==1 || n==2)
//           return 1;
//       if (n==3)
//           return 2;
//       int sum=1;
//       while (n>4){
//           sum*=3;
//           n-=3;
//       }
//
//       return sum*n;
//   }
    
}
