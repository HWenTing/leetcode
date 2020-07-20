package T1k_201_NOW;

import java.util.Arrays;

public class T1371 {

//	给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：
//	每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
	
//	第一反应 复杂度O(n^2) 位运算 dp
//	private int ans,len;
//    public int findTheLongestSubstring(String s) {
//    	len = s.length();
//    	ans=0;
//
//    	for(int i=0;i<len;i++){
//    		item(i,new int[len],s);
//    		if(ans>=len-i) break;
//    	}
//    	return ans;
//    }
//    private void item(int start,int[] dp,String s){
//    	if("aeiou".indexOf(s.charAt(start))>=0)
//    		dp[start] = dp[start]^s.charAt(start);
//    	else
//            ans = Math.max(ans, 1);
//
//    	for(int i=start+1;i<len;i++){
//    		if("aeiou".indexOf(s.charAt(i))>=0){
//    			dp[i] = dp[i-1]^s.charAt(i);
//    		}else
//    			dp[i] = dp[i-1];
//    		if(dp[i]==0){
//    			ans = Math.max(ans, i-start+1);
//    		}
//    	}
//    }
    
	//O(n)的方法
	public int findTheLongestSubstring(String s) {
		int len = s.length();
		int[] first = new int[1<<5];//记录某种元音组合第一次出现的索引
		Arrays.fill(first, -1);
		int ans=0,status=0;
		first[0]=0;
		
		for(int i=0;i<len;i++){
			int index = "aeiou".indexOf(s.charAt(i));
			if(index>=0){
				status^=1<<index;
			}
			
			if(first[status]>=0)//说明之前存在和目前相同的元音情况
				ans = Math.max(ans, i-first[status]+1);
			else
				first[status] = i+1;//记录下第一次出现的位置
			
		}
		return ans;
	}
	
	
	
}
