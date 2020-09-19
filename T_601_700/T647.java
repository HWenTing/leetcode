package T_601_700;

import java.util.Stack;

public class T647 {

//	计算这个字符串中有多少个回文子串。
//	具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
	
//	想法是以结尾为基准，计算以每个位置作为结尾时回文个数的加和
//	可以ac，但是很慢很慢，空间也很大
//    public int countSubstrings(String s) {
//        int sum = 0;
//        int len=s.length();
//        
//        for(int i=1;i<=len;i++){
//        	sum+=getnum(s,i);
//        }
//        return sum;
//    }
//    
//    private int getnum(String s,int end){
//    	int sum = 0;
//    	for(int i=0;i<end;i++){
//    		sum+=ishuiwen(s.substring(i, end))?1:0;
//    	}
//    	return sum;
//    }
//    
//    private boolean ishuiwen(String s){//判断是否为回文
//    	if(s.length()<=1)
//    		return true;
//    	int start =0;
//    	int end = s.length()-1;
//    	while(start<end){
//    		if(s.charAt(start)!=s.charAt(end))
//    			return false;
//    		start++;
//    		end--;
//    	}
//    	return true;
//    }
	
	
//	法一
//	从字符串某一位开始，尝试扩展字符串
//	速度很快，也很省内存
//    private int cnt=0;
//	public int countSubstrings(String s) {
//        for(int i=0;i<s.length();i++){
//        	extendstring(s,i,i);//奇数长度
//        	extendstring(s,i,i+1);//偶数长度
//        }
//        return cnt;
//    }
//    
//    private void extendstring(String s, int start,int end){//向外扩展字符串
//    	while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
//    		cnt++;
//    		start--;
//    		end++;
//    	}
//    }
	
//	法二 O(n^2)
//	dp   dp[i][j] =  dp[i+1][j-1]&&s.charAt(i)==s.charAt(j) 
    public int countSubstrings(String s) {
    	if(s.length()<2) return s.length();
    	
    	boolean[][] dp = new boolean[s.length()][s.length()];
    	
    	int ans=1;
    	dp[0][0] = true;
    	for(int i =1;i<s.length();i++){
    		dp[i][i]=true;
    		ans++;
    		if(s.charAt(i-1)==s.charAt(i)){
    			dp[i-1][i] = true;
    			ans++;
    		}
    	}
    	
    	for(int len = 2;len<s.length();len++){//先遍历长度
    		for(int i=0;i+len<s.length();i++){
    			if(dp[i+1][i+len-1] && s.charAt(i)==s.charAt(i+len)){
    				dp[i][i+len] = true;
    				ans++;
    			}
    		}
    	}
    	return ans;
    }
	
//	法三
//	马拉车(manacher)算法 在O(n)的时间里寻找最长回文字符串 修改一下即可解决此题 复杂度O(N)
//    private int ans;
//	private int R ;//最右边界
//	private int C ;//最右边界对应的中心点
//	private int[] radios;//每个点对应的回文半径 最小是1 也就是本身
//	
//    public int countSubstrings(String s) {
//    	if(s.length()<2) return s.length();
//    	ans = 0;
//    	StringBuilder sb = new StringBuilder();
//		sb.append('#');
//		for(char c:s.toCharArray()){//先预处理字符串 对奇数长度和偶数长度统一处理
//			sb.append(c);
//			sb.append('#');
//		}
//		R = -1;
//		C = -1;
//		radios = new int[sb.length()];
//		
//		for(int i=0;i<sb.length();i++){
//			if(i>=R){//正常向外扩
//				expand(i-1,i+1,i,sb);
//			}else{
//				int L = 2*C-R;//最右边界对应的最左边界
//				int symmetric_points = 2*C-i;//i点关于中心的对称点
//				if(symmetric_points - radios[symmetric_points]+1>L){//如果对称点的最左边界在[L,R]内，则i的半径与对称点相同（因为[L,R]都是回文的）
//					radios[i] = radios[symmetric_points];
//				}else if(symmetric_points - radios[symmetric_points]+1 == L){//如果对称点的最左边界刚好等于L，那么i点只需要从R继续向外扩就好，因为R以内的和i的对称点相同
//					expand(i- radios[symmetric_points],R+1,i,sb);
//				}else{////如果对称点的最左边界在小于L，那么i的半径向右最多到R（如果大于R，矛盾了）
//					radios[i] = R-i+1;
//				}
//			}
//			ans+=radios[i]/2;
//		}
//    	return ans;
//    }
//
//
//	private void expand(int left,int right,int i,StringBuilder sb){
//		while(left>=0 && right<sb.length() && sb.charAt(left)==sb.charAt(right)){
//			left--;
//			right++;
//		}
//		if(right-1>R){//更新R值和C值
//			C = i;
//			R = right-1;
//		}
//		radios[i] = i-left;
//	}
	
}
