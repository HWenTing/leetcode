package T_601_700;

public class T650 {
	
//	这个题。。一开始没做出来。
//	看了题解才发现，这是质因子分解，然后求和？？
    public int minSteps(int n) {
    	if(n==1)
    		return 0;
    	
        int []dp = new int[n+1];
        
        for(int i=2;i<=n;i++){
        	dp[i]=i;
        	for(int j=2;j<=(int)Math.sqrt(n);j++){
        		if(i%j==0){
        			dp[i] = dp[j]+dp[i/j];
        			break;
        		}
        	}
        }
        	
        return dp[n];

    }
    
//    更直观的质因子分解
//    public int minSteps(int n) {
//        int res = 0;
//        for (int i = 2; i <= n; i++) {
//            while (n % i == 0) {
//                res += i;
//                n /= i;
//            }
//        }
//        return res;
//    }
    
    
    public static void main(String[] args){
    	T650 t =new T650();
    	System.out.println(t.minSteps(3));
    }
}
