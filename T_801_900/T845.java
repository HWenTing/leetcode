package T_801_900;

public class T845 {

	
//	我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
//	B.length >= 3
//	存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
//	（注意：B 可以是 A 的任意子数组，包括整个数组 A。）
//	给出一个整数数组 A，返回最长 “山脉” 的长度。
//	如果不含有 “山脉” 则返回 0。

//	找到山顶，然后向前后扩张

//    public int longestMountain(int[] A) {
//    	int len = A.length;
//    	if(len<3) return 0;
//    	
//    	int ans=0;
//    	for(int i=1;i<len-1;i++){
//    		if(A[i]>A[i+1] && A[i]>A[i-1])
//    			ans = Math.max(ans, expand(i,A));
//    	}
//    	return ans;
//    }
//
//	private int expand(int i, int[] A) {
//		int left=i-1;
//		while(left>=0 && A[left]<A[left+1])
//			left--;
//		
//		int right=i+1;
//		while(right<A.length && A[right]<A[right-1])
//			right++;
//		
//		return right-left-1;
//	}
	
	
//	进一步优化，在扩张时，返回右边界，下一次寻找山顶时直接从右边界开始找起
    int ans;
    public int longestMountain(int[] A) {
    	int len = A.length;
    	if(len<3) return 0;
    	
    	ans=0;//这个地方要小心，，不要写成int ans = 0; 否则ans会被覆盖
    	for(int i=1;i<len-1;i++){
    		if(A[i]>A[i+1] && A[i]>A[i-1])
    			 i = expand(i,A)-1;
    	}
    	return ans;
    }

	private int expand(int i, int[] A) {
		int left=i-1;
		while(left>=0 && A[left]<A[left+1])
			left--;
		
		int right=i+1;
		while(right<A.length && A[right]<A[right-1])
			right++;
		
		ans = Math.max(ans,right-left-1);
		return right;
	}
    
    
}
