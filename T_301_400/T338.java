package T_301_400;

public class T338 {

//	给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
	
//	感觉有点像找规律,ans[i] = 1+ans[i-Integer.highestOneBit(i)];
//	击败32%，有点慢
//    public int[] countBits(int num) {
//        int[] ans = new int[num+1];
//        ans[0]=0;
//        for(int i=1;i<=num;i++){
//        	ans[i] = 1+ans[i-Integer.highestOneBit(i)];
//        }
//        return ans;
//    }
    
	
//	击败76%
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        ans[0]=0;
        for(int i=1;i<=num;i++){
        	ans[i] = 1+ans[i&(i-1)];//dp的关键
        }
        return ans;
    }

	
}
