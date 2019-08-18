package T_401_500;

import java.util.LinkedList;
import java.util.List;

public class T438 {

	
//	给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
	
//	想法就是遍历，配合一定剪枝
//	嘤嘤嘤好慢啊。。击败了%12
//    public List<Integer> findAnagrams(String s, String p) {
//    	int lens = s.length();
//        int lenp = p.length();
//        List<Integer> ans = new LinkedList<>();
//        boolean before=false;
//        for(int i=0;i<=lens-lenp;i++){
//        	if(before){//如果上一个位置是字母异位词，那么下一个只需要判断上一个的头和下一个的尾是否相等即可
//        		if(s.charAt(i-1)==s.charAt(i-1+lenp)){
//        			ans.add(i);
//        		}else{
//        			before = false;
//        		}
//        	}else{
//        		before=check(s.substring(i,i+lenp),p);
//        		if(before)
//        			ans.add(i);
//        	}
//        }
//        return ans;
//    }
//    
//    private boolean check(String s1,String s2){//判断两个相同长度字符串是否为字母异位词
//    	int[] cnt = new int[26];
//    	for(int i=0;i<s1.length();i++){
//    		cnt[s1.charAt(i)-'a']++;
//    		cnt[s2.charAt(i)-'a']--;
//    	}
//    	
//    	for(int i:cnt){
//    		if(i!=0)
//    			return false;
//    	}
//    	return true;
//    }
	
//	类似滑动窗口的思想，进来一个cnt++,出去一个cnt--,26位数组全为0说明ok
//	击败58%
    public List<Integer> findAnagrams(String s, String p) {
    	int lens = s.length();
    	int lenp = p.length();
    	List<Integer> ans = new LinkedList<>();
    	if(lens<lenp) return ans;
    	
    	int[] cnt = new int[26];
    	for(char c:p.toCharArray()){//初始化
    		cnt[c-'a']--;
    	}
    	int pos;
    	for(pos=0;pos<lenp;pos++){//初始化
    		cnt[s.charAt(pos)-'a']++;
    	}
    	for(;pos<lens;pos++){//从lenp位开始，启动滑动窗口思想
    		if(check(cnt))
    			ans.add(pos-lenp);
    		
    		cnt[s.charAt(pos)-'a']++;
    		cnt[s.charAt(pos-lenp)-'a']--;
    	}
    	if(check(cnt)) ans.add(pos-lenp);
    	return ans;
    }
    
	private boolean check(int[] cnt){
		for(int i:cnt)
			if(i!=0)
				return false;
		return true;
	}
	
}
