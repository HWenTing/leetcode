package T1k_101_200;

public class T1189 {

//	给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
//	字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。

	
//	计数
    public int maxNumberOfBalloons(String text) {
        int[] cnt=new int[26];
        for(char c:text.toCharArray())
        	cnt[c-'a']++;
        
        int ans=text.length();
        
        //要注意的是。。balloon中间有两个重复的字符
        for(char c:"ban".toCharArray())
        	ans = Math.min(ans, cnt[c-'a']);
        for(char c:"lo".toCharArray())
        	ans = Math.min(ans, cnt[c-'a']/2);
        return ans;
    }
    
}
