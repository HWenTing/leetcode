package T_901_1000;

import java.util.Arrays;

public class T910 {
	
	
//	给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
//			在此过程之后，我们得到一些数组 B。
//			返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
			
//	在某个点，前面的都+K，后面的都-K，相当于把原来的升序线段错成了两段，比较四个顶点即可
    public int smallestRangeII(int[] A, int K) {
        int N = A.length;
        Arrays.sort(A);
        int ans = A[N-1] - A[0];

        for (int i = 0; i < A.length - 1; ++i) {
            int a = A[i], b = A[i+1];
            int high = Math.max(A[N-1] - K, a + K);//两个较高顶点
            int low = Math.min(A[0] + K, b - K);//两个较低顶点
            ans = Math.min(ans, high - low);//作差
        }
        return ans;
    }

}
