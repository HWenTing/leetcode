package T1k_101_200;

public class T1175 {

//	请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
//	让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
//	由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。

	
//	先找到多少个质数，然后n-num 全排列  与n的全排列乘积
    public int numPrimeArrangements(int n) {
    	if(n<3) return 1;
    	long ans=1;//这里用long，否则会溢出
    	int MODE = 1000000007;
        int primeCnt = cntPrime(n);
        
        for(int i=primeCnt;i>1;i--){
        	ans*=i;
        	ans%=MODE;
        }
        
        for(int i=n-primeCnt;i>1;i--){
        	ans*=i;
        	ans%=MODE;
        }
        return (int) ans;
    }
    
//    计算小于等于n的质数的个数
    private int cntPrime(int n){
    	boolean[] marked = new boolean[n+1];
    	int aqrt = (int) Math.sqrt(n);
    	for(int i=2;i<=aqrt;i++){
    		if(!marked[i]){
    			int cur = i+i;
    			while(cur<=n){
    				marked[cur]=true;
    				cur+=i;
    			}
    		}
    	}
    	
    	int ans=0;
    	for(int i=2;i<=n;i++){
    		if(!marked[i])
    			ans++;
    	}
    	return ans;
    }
}
