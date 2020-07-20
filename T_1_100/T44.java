package T_1_100;

public class T44 {

//	给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
//	'?' 可以匹配任何单个字符。
//	'*' 可以匹配任意字符串（包括空字符串）。
	
//	看了解析 动态规划 重点思考转移方程 dp[i][j]表示s的前i个字母是否与p的前j个字母匹配
    public boolean isMatch(String s, String p) {
    	
    	int slen = s.length();
    	int plen = p.length();
    	char[] schar = s.toCharArray();
    	char[] pchar = p.toCharArray();
    	boolean[][] dp = new boolean[slen+1][plen+1];
    	
    	dp[0][0] = true;
    	for(int i=1;i<=plen;i++){
    		if(pchar[i-1]=='*')
    			dp[0][i] = true;
    		else
    			break;
    	}
    	
    	for(int i=1;i<=slen;i++){
    		for(int j=1;j<=plen;j++){
    			if(pchar[j-1]=='*'){
    				dp[i][j] = dp[i][j-1] || dp[i-1][j-1] || dp[i-1][j];//分别对应了 *匹配空、*匹配一个字母、*匹配两个字母
    			}else if(pchar[j-1]=='?' || (pchar[j-1]==schar[i-1]) )
    				dp[i][j] = dp[i-1][j-1];
    		}
    	}
    	
    	return dp[slen][plen];
    }
}
