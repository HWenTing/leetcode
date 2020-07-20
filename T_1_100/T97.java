package T_1_100;

public class T97 {

//	给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
	
//	第一想法是双指针+dfs+剪枝  时间击败5%。。。。
//	private boolean interleave;
//	private String S1,S2,S3;
//    public boolean isInterleave(String s1, String s2, String s3) {
//    	if(s3.length()!=s1.length()+s2.length()) return false;
//    	interleave = false;
//    	S1 = s1;S2 = s2; S3 = s3;
//    	dfs(0,0,0);
//    	return interleave;	
//    }
//    
//	private void dfs(int s1pos, int s2pos, int s3pos) {
//		if(interleave||s3pos==S3.length()){
//			interleave = true;
//			return;
//		}
//		if(s1pos<S1.length() && S1.charAt(s1pos)==S3.charAt(s3pos))
//			dfs(s1pos+1,s2pos,s3pos+1);
//		if(interleave) return ;//剪枝
//		if(s2pos<S2.length() && S2.charAt(s2pos)==S3.charAt(s3pos))
//			dfs(s1pos,s2pos+1,s3pos+1);
//	}
	
//	dp dp[i][j]表示 s1的前i个字母 和s2的前j个字母能否构成s3的前i+j个字母
	public boolean isInterleave(String s1, String s2, String s3) {
    	if(s3.length()!=s1.length()+s2.length()) return false;
    	
    	boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
    	
    	dp[0][0] = true;
    	
    	for(int i=0;i<=s1.length();i++){
        	for(int j=0;j<=s2.length();j++){
        		if(i>0)
        			dp[i][j] = dp[i][j] || (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1));
        		if(j>0)
        			dp[i][j] = dp[i][j] || (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
        	}
    	}
    	
    	return dp[s1.length()][s2.length()];
	}
	
}
