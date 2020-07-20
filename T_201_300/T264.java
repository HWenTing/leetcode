package T_201_300;

public class T264 {
	
//	编写一个程序，找出第 n 个丑数。
//	丑数就是只包含质因数 2, 3, 5 的正整数。
    
//	dp 看到的解析 太妙了 相当于三指针问题
//	A：{1*2，2*2，3*2，4*2，5*2，6*2，8*2，10*2......}
//	B：{1*3，2*3，3*3，4*3，5*3，6*3，8*3，10*3......}
//	C：{1*5，2*5，3*5，4*5，5*5，6*5，8*5，10*5......}
	
	public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0]=1;
        int n1=0;
        int n2=0;
        int n3=0;
        for(int i=1;i<n;i++){

        	dp[i] = Math.min(Math.min(dp[n1]*2,dp[n2]*3), dp[n3]*5);
        	if(dp[i] == dp[n1]*2) n1++;//每一个都要if 不能else if 因为处理6时 2和3都要操作	
        	if(dp[i] == dp[n2]*3) n2++;
        	if(dp[i] == dp[n3]*5) n3++;
        	System.out.println(dp[i]);
        }
        return dp[n-1];
    }
    
}
