package T_701_800;

public class T781 {

//	森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
//	返回森林中兔子的最少数量。

//	计算每个答案的个数 比如如果回答2的兔子是3，那么刚好可以凑成一组，最少是3.
    public int numRabbits(int[] answers) {
    
    	int[] cnt = new int[1000];
    	for(int i:answers)//计算每个答案的个数
    		cnt[i]++;
    	
    	int ans=0;
    	for(int i=0;i<1000;i++){
    		ans += (i+1)*(int)Math.ceil(cnt[i]/(i+1.0));
    	}
    	return ans;
    	
    	
    }
 
//    一样的思路，更简洁一点
//    public int numRabbits(int[] answers) {
//        int count = 0;
//        int[] nums = new int[1000];
//        for (int i : answers) {
//            if (nums[i] == 0 || nums[i] % (i + 1) == 0) {
//                count += i + 1;
//            }
//            nums[i]++;
//        }
//        return count;
//    }
    
}
