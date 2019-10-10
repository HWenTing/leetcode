package T_801_900;

public class T821 {
//	给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
	
//	正着一遍，反着一遍，取最小值
    public int[] shortestToChar(String S, char C) {
    	int[] ans = new int[S.length()];
    	
    	int lastc=-30000;
    	for(int i=0;i<S.length();i++){
    		if(S.charAt(i)==C)
    			lastc=i;
    		ans[i] =i-lastc;
    	}
    	
    	lastc=30000;
    	for(int i=S.length()-1;i>=0;i--){
    		if(S.charAt(i)==C){
    			lastc=i;
    		}else{
    			ans[i] = Math.min(ans[i], lastc-i);
    		}
    	}
    	return ans;
    	
    }
    
}
