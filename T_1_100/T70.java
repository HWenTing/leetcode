package T_1_100;

public class T70 {
//动态规划 dp[n] = dp[n-1]+dp[n-2]
	//递归的方法超时了
//    public int climbStairs(int n) {
//        if(n==1)
//        	return 1;
//        if(n==2)
//        	return 2;
//        return climbStairs(n-1)+climbStairs(n-2);
//    }
    
	public int climbStairs(int n) {
		if(n<3)
			return n;
		
		int pre1 = 2;
		int pre2 = 1;
		int cur = 0;
		for(int i=2;i<n;i++){
			cur = pre1+pre2;
			pre2 = pre1;
			pre1 = cur;
		}
		return cur;
	}
	
	
	public static void main(String[] args) {
		T70 t = new T70();
		System.out.println(t.climbStairs(44));

	}

}
