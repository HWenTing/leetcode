package T_401_500;

import java.util.Arrays;

public class T410 {

//	给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
	
//	看了题解 动态规划
//	 dp[i][j]表示将数组的前 i个数分割为 j段所能得到的最大连续子数组和的最小值
//	public int splitArray(int[] nums, int m) {
//		
//		int n = nums.length;
//		int[][]dp = new int[n+1][m+1];
//		for(int[] cur:dp)
//			Arrays.fill(cur, Integer.MAX_VALUE);
//		
//		int[] sub = new int[n+1];
//		for(int i =0;i<n;i++)//前缀和
//			sub[i+1] = sub[i]+nums[i];
//		
//		dp[0][0] = 0;
//		for(int i =1;i<=n;i++){
//			int temp = Math.min(i, m);
//			for(int j=1;j<=temp;j++){
//				for(int k=j-1;k<i;k++){
//					dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sub[i]-sub[k]));
//				}
//			}
//		}
//		
//		return dp[n][m];
//    }

	
//	或者用二分法 很巧妙
    public int splitArray(int[] nums, int m) {
        int left = 0;//下界 max(nums)
        int right = 0;//上界 sum(nums)
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            int mid = (right - left) / 2 + left;//以mid为标准进行分组
            if (check(nums, mid, m)) {//如果分的组数小于m  则将标准定小一点
                right = mid;
            } else {//反之，将标准定大一点
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int x, int m) {//检查以x为标准分组 得到的组数与m进行比较
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }
	
}

