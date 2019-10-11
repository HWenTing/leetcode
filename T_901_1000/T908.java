package T_901_1000;

public class T908 {

//	给定一个整数数组 A，对于每个整数 A[i]，我们可以选择任意 x 满足 -K <= x <= K，并将 x 加到 A[i] 中。
//			在此过程之后，我们得到一些数组 B。
//			返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
	
//	找A中最值，若差小于2*k，返回0;
    public int smallestRangeI(int[] A, int K) {
        int min = A[0];
        int max = A[0];
        for(int i:A){
        	min = Math.min(min, i);
        	max = Math.max(max, i);
        }
        int abs = max-min;
        return abs<=2*K?0:abs-2*K;
    }
}
