package T_401_500;

public class T494 {
	
//	a-b=S
//	a+b=sum
//	-->a=(S+sum)/2
//	取子集和为(S+sum)/2
//	dp来做
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {//求和
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int w = (sum + S) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = w; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[w];
    }
    
    public static void main(String[] args){
    	T494 t = new T494();
    	System.out.println(t.findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}, 0));
    }
    
}
