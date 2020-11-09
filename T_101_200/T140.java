package T_101_200;

import java.util.LinkedList;
import java.util.List;

public class T140 {

//	给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
//	说明：
//	分隔时可以重复使用字典中的单词。
//	你可以假设字典中没有重复的单词。

//	同139 先dp判断是否可以满足条件，同时记录下每个位置到达的前序节点 然后回溯找路经
	private List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        List<String> []dp = new LinkedList[len+1];
        
        dp[0] = new LinkedList<>();

        for(int i=1;i<=len;i++){
            for(String word:wordDict){
                if(i-word.length()>=0 && dp[i-word.length()]!=null && word.equals(s.substring(i-word.length(),i))){
                	if(dp[i] == null)
                		dp[i] = new LinkedList<>();
                	dp[i].add(word);
                }
            }
        }
        ans = new LinkedList<>();
        if(dp[len]!=null)
        	dfs(len,dp,new StringBuffer());
        return ans;
    }
    
    private void dfs(int len,List<String> []dp,StringBuffer cur){
    	if(len==0){
    		cur.deleteCharAt(0);
    		ans.add(cur.toString());
    	}
    	for(String s:dp[len]){
    		StringBuffer next = new StringBuffer(cur);
    		next.insert(0, s);
    		next.insert(0, " ");
    		dfs(len-s.length(),dp,next);
    	}
    }
}
