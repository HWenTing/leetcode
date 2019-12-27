package T1k_201_300;

public class T1295 {
//	给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。

//	 转换成字符串算长度
//    public int findNumbers(int[] nums) {
//        int ans = 0;
//        for(int i:nums){
//        	if((i+"").length()%2==0)
//        		ans++;
//        }
//        return ans;
//    }
	
//    # log10(n)，表示以10为底n的对数
//    # log10(10)    1.0
//    # log10(100)   2.0
//    # log10(9100)  3.9590413923210934
//    
//    # 刚好可以用这个求出数字的位数
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int i:nums){
        	if((int)(Math.log10(i)+1)%2==0)
        		ans++;
        }
        return ans;
    }
    

}
