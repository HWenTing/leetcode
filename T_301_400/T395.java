package T_301_400;

import java.util.LinkedList;

public class T395 {

//	找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
	
//	递归 找到分割点 对每段分割
    public int longestSubstring(String s, int k) {

    	int[] cnt = new int[26];
    	for(char c:s.toCharArray())
    		cnt[c-'a']++;
    	
    	LinkedList<Integer> cutpoint = new LinkedList<>();
    	for(int i=0;i<s.length();i++)
    		if(cnt[s.charAt(i)-'a']<k)
    			cutpoint.add(i);
    	
    	if(cutpoint.size()==0) return s.length();
    	cutpoint.add(s.length());
    	int before = 0;
    	int ans = 0;
    	for(int i:cutpoint){
    		if(i-before>ans)
    			ans = Math.max(ans, longestSubstring(s.substring(before,i),k));
    		before = i+1;
    	}
    	
    	return ans;
    }
    
}
