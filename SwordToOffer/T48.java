package SwordToOffer;

import java.util.HashSet;
import java.util.Set;

public class T48 {
	
//	请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
	
//	双指针 滑动窗口 同T3
    public int lengthOfLongestSubstring(String s) {
    	if(s.length()<2) return s.length();
    	
    	Set<Character> set = new HashSet<>();//这里也可以用256位的数组来标记
    	int left = 0;
    	int right = 1;
    	int ans = 1;
    	set.add(s.charAt(0));
    	
    	while(right<s.length()){
    		char cur = s.charAt(right);
    		if(!set.contains(cur)){
    			set.add(cur);
    			right++;
    			ans = Math.max(ans, right-left);
    		}else{
    			while(s.charAt(left)!=cur){
    				set.remove(s.charAt(left));
    				left++;
    			}
    			set.remove(s.charAt(left));
    			left++;
    		}
    	}
    	return ans;
    }
    
//    public static void main(String[] args) {
//		System.out.println((int)' ');
//	}
}
