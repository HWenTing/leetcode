package SwordToOffer;

public class T60 {

//	把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
//	你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
	
//	动态规划 dp[i] = dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4]+dp[i-5]+dp[i-6] 注意范围
    public double[] twoSum(int n) {
    	
    	double item = 1.0/Math.pow(6, n);//计算一单位的大小
    	int[] dp = new int[n*6+1];
    	
    	for(int i=1;i<=6;i++)
    		dp[i]=1;
    	
    	for(int i=1;i<n;i++){//n个筛子
    		for(int j=6*(i+1);j>i;j--){//扔第n个筛子的范围是n~6*n
    			int temp=0;
    			for(int k = 1;k<=6;k++){//每个位置最多向前看6步
    				if(j-k<i) break;
    				temp+=dp[j-k];
    			}
    			dp[j] = temp;
    		}
    	}
    	
    	double[] ans = new double[n*6-n+1]; 
    	for(int i=n;i<dp.length;i++){//与单位大小乘积
    		ans[i-n] = item*dp[i];
    	}
    	return ans;
    }
    
}
