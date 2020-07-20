package SwordToOffer;

public class T56_1 {

//	给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
	
//	同T260 位运算
//	先都求一遍异或，得到diff，然后diff&(-diff)得到diff中最低的那一位1，说明两个数a，b在该位置肯定一个1，一个0，
//	然后通过该位的0，1分成两组，a和b肯定一边一个，然后再分别异或，分别求出a和b
    public int[] singleNumbers(int[] nums) {
        int diff=0;
    	for(int num:nums)//求diff
    		diff^=num;
    	
    	int[] ans=new int[2];
    	int pos = diff&(-diff);//求位置
    	for(int num:nums){
    		if((num&pos)==0)//分别异或，这个地方要注意是0，因为只会出现0或非0的情况。而不是1或非1
    			ans[0]^=num;
    		else
    			ans[1]^=num;
    	}
    	return ans;
    }
    
}
