package T_801_900;

public class T832 {

//	给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
	
    public int[][] flipAndInvertImage(int[][] A) {
    	for(int i=0;i<A.length;i++){
    		swap(A[i]);
    	}
    	return A;
    }

//    反转交换一行
	private void swap(int[] is) {
		int left = 0;
		int right = is.length-1;
		while(left<right){
			int templ = is[left];
			int tempr = is[right];
			is[left] = tempr^1;
			is[right] = templ^1;
			left++;
			right--;
		}
		if(left==right)
			is[left] = is[left]^1;
		
	}
    
}
